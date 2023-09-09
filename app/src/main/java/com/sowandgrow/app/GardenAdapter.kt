package com.sowandgrow.app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class GardenAdapter(private val gardenList: ArrayList<Garden>, private val onItemClick: (Garden) -> Unit) :
    RecyclerView.Adapter<GardenAdapter.GardenViewHolder>() {

    class GardenViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView3: ImageView = itemView.findViewById(R.id.imageView3)
        val textView3: TextView = itemView.findViewById(R.id.textView3)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GardenViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.grid_view_card, parent, false)
        return GardenViewHolder(view)
    }

    override fun getItemCount(): Int {
        return gardenList.size
    }

    override fun onBindViewHolder(holder: GardenViewHolder, position: Int) {
        val garden = gardenList[position]
        holder.imageView3.setImageResource(garden.image)
        holder.textView3.text = garden.name

        // Set click listener for the item
        holder.itemView.setOnClickListener {
            onItemClick(garden)
        }
    }
}