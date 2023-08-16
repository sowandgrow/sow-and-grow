package com.example.sowandgrow;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class DiscoverRecyclerView extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discover_recycler_view);

        List<PlantData> plantDataList = new ArrayList<>();
        plantDataList.add(new PlantData("Tulsi", "Ocimum tenuiflorum"));
        plantDataList.add(new PlantData("Orhul", "Hibiscus rosa-sinensis"));

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        PlantDataAdapter adapter = new PlantDataAdapter(plantDataList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}