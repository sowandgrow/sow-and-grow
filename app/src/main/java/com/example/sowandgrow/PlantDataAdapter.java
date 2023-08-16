package com.example.sowandgrow;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PlantDataAdapter extends RecyclerView.Adapter<PlantDataAdapter.ViewHolder> {
    private List<PlantData> plantDataList;

    public PlantDataAdapter(List<PlantData> plantDataList) {
        this.plantDataList = plantDataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_discover_recycler_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PlantData plantData = plantDataList.get(position);

        holder.tvCommonName.setText(plantData.getCommonName());
        holder.tvBotanicalName.setText(plantData.getBotanicalName()); // Changed view ID from tvLatinName
        // Bind other views...
    }

    @Override
    public int getItemCount() {
        return plantDataList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvCommonName, tvBotanicalName; // Changed view ID from tvLatinName
        // Other views...

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCommonName = itemView.findViewById(R.id.tv_common_name);
            tvBotanicalName = itemView.findViewById(R.id.tv_botanical_name); // Changed view ID
            // Initialize other views...
        }
    }
}
