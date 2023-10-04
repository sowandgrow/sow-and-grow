package com.sowandgrow.app.fragments;


import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.sowandgrow.app.data.DataClass;
import com.sowandgrow.app.adapters.MyAdapter;
import com.sowandgrow.app.utils.ProfileActivity;
import com.sowandgrow.app.R;
import com.sowandgrow.app.utils.UploadActivity;
import com.sowandgrow.app.utils.BaseActivity;
import de.hdodenhof.circleimageview.CircleImageView;

import java.util.ArrayList;
import java.util.List;

public class MyGarden extends Fragment {

    private FloatingActionButton fab;
    private List<DataClass> dataList;
    private MyAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_garden, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView1);
        FloatingActionButton plusIconButton1 = view.findViewById(R.id.plusIconButton);
        SearchView searchView = view.findViewById(R.id.search);
        searchView.clearFocus();

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 1);
        recyclerView.setLayoutManager(gridLayoutManager);

        dataList = new ArrayList<>();
        adapter = new MyAdapter(getActivity(), dataList);
        recyclerView.setAdapter(adapter);

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Android Plants");

        BaseActivity baseActivity = (BaseActivity) getActivity();
        baseActivity.showProgressBar();

        // Hides the Progress Bar
        ValueEventListener eventListener = databaseReference.addValueEventListener(new ValueEventListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                dataList.clear();
                for (DataSnapshot itemSnapshot : snapshot.getChildren()) {
                    DataClass dataClass = itemSnapshot.getValue(DataClass.class);
                    dataClass.setKey(itemSnapshot.getKey());
                    dataList.add(dataClass);
                }
                adapter.notifyDataSetChanged();

                // Hides the Progress Bar
                baseActivity.hideProgressBar();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                baseActivity.hideProgressBar();
            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                searchList(newText);
                return true;
            }
        });

        // Click listener for profilePictureButton
        CircleImageView profilePictureButton = view.findViewById(R.id.profilePictureButton);
        profilePictureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start ProfileActivity
                Intent intent = new Intent(getActivity(), ProfileActivity.class);
                startActivity(intent);
            }
        });

        // Load and display user's Google profile picture
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            String photoUrl = user.getPhotoUrl() != null ? user.getPhotoUrl().toString() : null;
            if (photoUrl != null) {
                // Use Glide to load and display the profile picture
                Glide.with(this)
                        .load(photoUrl)
                        .into(profilePictureButton);
            }
        }

        // Click listener for plusIconButton
        ImageButton plusIconButton = view.findViewById(R.id.plusIconButton);
        plusIconButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), UploadActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }

    public void searchList(String text) {
        ArrayList<DataClass> searchList = new ArrayList<>();
        for (DataClass dataClass : dataList) {
            if (dataClass.getDataName().toLowerCase().contains(text.toLowerCase())) {
                searchList.add(dataClass);
            }
        }
        adapter.searchDataList(searchList);
    }
}