package com.sowandgrow.app.utils;

import androidx.appcompat.widget.SearchView;
import android.os.Bundle;
import com.sowandgrow.app.R;
import com.sowandgrow.app.adapters.PlantsAdapter;
import com.sowandgrow.app.data.PlantsModel;
import android.annotation.SuppressLint;
import android.widget.Toast;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class DiscoverPlants extends BaseActivity {

    private List<PlantsModel> dataList;
    private PlantsAdapter adapter;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discover_plants);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        searchView = findViewById(R.id.searchView);
        searchView.clearFocus();

        GridLayoutManager gridLayoutManager = new GridLayoutManager(DiscoverPlants.this, 1);
        recyclerView.setLayoutManager(gridLayoutManager);

        dataList = new ArrayList<>();

        adapter = new PlantsAdapter(DiscoverPlants.this, dataList);
        recyclerView.setAdapter(adapter);

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("plants");

        // Show the ProgressBar
        showProgressBar();

        ValueEventListener eventListener = databaseReference.addValueEventListener(new ValueEventListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                dataList.clear();
                for (DataSnapshot itemSnapshot : snapshot.getChildren()) {
                    PlantsModel plantsModel = itemSnapshot.getValue(PlantsModel.class);
                    dataList.add(plantsModel);
                }

                // Sort the dataList based on plant names
                dataList.sort(new Comparator<PlantsModel>() {
                    @Override
                    public int compare(PlantsModel plant1, PlantsModel plant2) {
                        return plant1.getPlantName().compareToIgnoreCase(plant2.getPlantName());
                    }
                });
                adapter.notifyDataSetChanged();

                // Hides the Progress Bar
                hideProgressBar();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(DiscoverPlants.this, "Failed To Load", Toast.LENGTH_SHORT).show();
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
    }

    public void searchList(String text) {
        ArrayList<PlantsModel> searchList = new ArrayList<>();
        for (PlantsModel plantsModel : dataList) {
            if (plantsModel.getPlantName().toLowerCase().contains(text.toLowerCase())) {
                searchList.add(plantsModel);
            }
        }
        adapter.searchDataList(searchList);
    }
}
