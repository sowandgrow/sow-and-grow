package com.sowandgrow.app.fragments;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.airbnb.lottie.LottieAnimationView;
import com.sowandgrow.app.R;
import com.sowandgrow.app.utils.DiscoverPlants;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Discover extends Fragment {

    LottieAnimationView search;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        search = view.findViewById(R.id.search);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to start the DiscoverPlant activity
                Intent intent = new Intent(getActivity(), DiscoverPlants.class);
                startActivity(intent);
            }
        });

        return view;
    }
}
