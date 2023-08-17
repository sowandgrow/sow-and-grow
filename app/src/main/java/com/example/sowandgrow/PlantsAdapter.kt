package com.example.sowandgrow

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PlantsAdapter(private val plantsList:ArrayList<Plants>)
    : RecyclerView.Adapter<PlantsAdapter.PlantsViewHolder>(){

    class PlantsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        val imageView : ImageView = itemView.findViewById(R.id.imageviewplant)
        val textView : TextView = itemView.findViewById(R.id.textviewplant)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlantsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.each_item, parent,false)
        return  PlantsViewHolder(view)
    }
    override fun onBindViewHolder(holder: PlantsViewHolder, position: Int) {
        val plants = plantsList[position]
        holder.imageView.setImageResource(plants.image)
        holder.textView.text = plants.name
    }
    override fun getItemCount(): Int {
        return plantsList.size
    }


}