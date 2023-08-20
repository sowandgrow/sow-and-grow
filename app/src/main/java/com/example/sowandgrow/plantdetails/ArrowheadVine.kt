package com.example.sowandgrow.plantdetails

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.sowandgrow.Plants
import com.example.sowandgrow.R

class ArrowheadVine : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_arrowhead_vine)

        val plant = intent.getParcelableExtra<Plants> ("plants")
        if (plant !=null){
            val textView1: TextView = findViewById(R.id.plant_name_view2)
            val textView2: TextView =findViewById(R.id.plant_type2)
            val imageView : ImageView = findViewById(R.id.plant_image_view)
            textView1.text = plant.name
            textView2.text=plant.name
            imageView.setImageResource(plant.image)
        }
    }
}