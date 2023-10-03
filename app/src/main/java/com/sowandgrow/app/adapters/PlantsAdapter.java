package com.sowandgrow.app.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.sowandgrow.app.R;
import com.sowandgrow.app.data.PlantsModel;
import com.sowandgrow.app.utils.DiscoverDetail;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class PlantsAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private Context context;
    private List<PlantsModel> dataList;

    public PlantsAdapter(Context context, List<PlantsModel> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.each_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Glide.with(context)
                .load(dataList.get(position)
                .getImageResource())
                .placeholder(R.drawable.sowandgrowlogo)
                .into(holder.discoverPlantImage);
        holder.discoverPlantName.setText(dataList.get(position).getPlantName());

        holder.eachItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DiscoverDetail.class);
                intent.putExtra("DiscoverImage", dataList.get(holder.getAdapterPosition()).getImageResource());
                intent.putExtra("DiscoverPlantName", dataList.get(holder.getAdapterPosition()).getPlantName());
                intent.putExtra("DiscoverPlantBotanical", dataList.get(holder.getAdapterPosition()).getBotanicalName());
                intent.putExtra("DiscoverPlantType", dataList.get(holder.getAdapterPosition()).getPlantType());
                intent.putExtra("DiscoverBloomTime", dataList.get(holder.getAdapterPosition()).getBloomTime());
                intent.putExtra("DiscoverPlantColor", dataList.get(holder.getAdapterPosition()).getPlantColor());
                intent.putExtra("DiscoverNativeArea", dataList.get(holder.getAdapterPosition()).getNativeArea());
                intent.putExtra("DiscoverPlantToxicity", dataList.get(holder.getAdapterPosition()).getToxicity());
                intent.putExtra("DiscoverSunExposure", dataList.get(holder.getAdapterPosition()).getSunExposure());
                intent.putExtra("DiscoverCare", dataList.get(holder.getAdapterPosition()).getCare());
                intent.putExtra("DiscoverPlantWater", dataList.get(holder.getAdapterPosition()).getWater());
                intent.putExtra("DiscoverPlantSun", dataList.get(holder.getAdapterPosition()).getSun());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void searchDataList(ArrayList<PlantsModel> searchList){
        dataList = searchList;
        notifyDataSetChanged();
    }
}

class MyViewHolder extends RecyclerView.ViewHolder {

    ImageView discoverPlantImage;
    TextView discoverPlantName;
    CardView eachItem;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        discoverPlantImage = itemView.findViewById(R.id.discoverPlantImage);
        discoverPlantName = itemView.findViewById(R.id.discoverPlantName);
        eachItem = itemView.findViewById(R.id.eachItem);
    }
}
