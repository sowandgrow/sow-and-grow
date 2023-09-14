package com.sowandgrow.app;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private Context context;
    private List<DataClass> dataList;

    public MyAdapter(Context context, List<DataClass> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Glide.with(context).load(dataList.get(position).getDataImage()).into(holder.recImage);
        holder.recName.setText(dataList.get(position).getDataName());
        holder.recBot.setText(dataList.get(position).getDataBot());
        holder.recDesc.setText(dataList.get(position).getDataDesc());
        holder.recWater.setText(dataList.get(position).getDataWater());

        holder.recCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getBindingAdapterPosition(); // Use getBindingAdapterPosition() instead
                if (position != RecyclerView.NO_POSITION) {
                    Intent intent = new Intent(context, DetailActivity.class);
                    intent.putExtra("Image", dataList.get(position).getDataImage());
                    intent.putExtra("Name", dataList.get(position).getDataName());
                    intent.putExtra("Botanical", dataList.get(position).getDataBot());
                    intent.putExtra("Description", dataList.get(position).getDataDesc());
                    intent.putExtra("Water", dataList.get(position).getDataWater());
                    intent.putExtra("Key",dataList.get(position).getKey());
                    context.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public void searchDataList(ArrayList<DataClass> searchList){
        dataList = searchList;
        notifyDataSetChanged();
    }
}

class MyViewHolder extends RecyclerView.ViewHolder{

    ImageView recImage;
    CardView recCard;
    TextView recName, recBot, recDesc, recWater;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);

        recImage = itemView.findViewById(R.id.recImage);
        recCard = itemView.findViewById(R.id.recCard);
        recName = itemView.findViewById(R.id.recName);
        recBot = itemView.findViewById(R.id.recBot);
        recDesc = itemView.findViewById(R.id.recDesc);
        recWater = itemView.findViewById(R.id.recWater);
    }
}