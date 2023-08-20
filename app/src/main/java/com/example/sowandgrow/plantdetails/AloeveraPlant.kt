package com.example.sowandgrow.plantdetails

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.sowandgrow.Plants
import com.example.sowandgrow.R

class AloeveraPlant : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aloevera_plant)

        val plant = intent.getParcelableExtra<Plants> ("plants")
        if (plant !=null) {
            val textView1: TextView = findViewById(R.id.plant_name_view1)
            val textView2: TextView = findViewById(R.id.plant_type1)
            val imageView : ImageView = findViewById(R.id.plant_image_view1)
            textView1.text = plant.name
            textView2.text = plant.name
            imageView.setImageResource(plant.image)
        }
    }
}