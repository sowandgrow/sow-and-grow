package com.example.sowandgrow

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class GardenAdapter(private val gardenList: ArrayList<Garden>) :
    RecyclerView.Adapter<GardenAdapter.GardenViewHolder>() {

    class GardenViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView3)
        val textView: TextView = itemView.findViewById(R.id.textView3)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GardenViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.each_item, parent, false)
        return GardenViewHolder(view)
    }

    override fun getItemCount(): Int {
        return gardenList.size
    }

    override fun onBindViewHolder(holder: GardenViewHolder, position: Int) {
        val garden = gardenList[position]
        holder.imageView.setImageResource(garden.image)
        holder.textView.text = garden.name
    }
}


