package com.example.sowandgrow

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PlantsAdapter(private val originalPlantsList: List<Plants>)
    : RecyclerView.Adapter<PlantsAdapter.PlantsViewHolder>() {

    private val filteredPlantsList = ArrayList<Plants>(originalPlantsList)
    var onItemClick: ((Plants) -> Unit)? = null

    class PlantsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageviewplant)
        val textView: TextView = itemView.findViewById(R.id.textviewplant)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlantsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.each_item, parent, false)
        return PlantsViewHolder(view)
    }

    override fun onBindViewHolder(holder: PlantsViewHolder, position: Int) {
        val plant = filteredPlantsList[position]
        holder.imageView.setImageResource(plant.image)
        holder.textView.text = plant.name

        holder.itemView.setOnClickListener {
            onItemClick?.invoke(plant)
        }
    }

    override fun getItemCount(): Int {
        return filteredPlantsList.size
    }

    fun setFilteredList(filteredList: List<Plants>) {
        filteredPlantsList.clear()
        filteredPlantsList.addAll(filteredList)
        notifyDataSetChanged()
    }

    fun restoreOriginalList() {
        filteredPlantsList.clear()
        filteredPlantsList.addAll(originalPlantsList)
        notifyDataSetChanged()
    }
}
