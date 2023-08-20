package com.example.sowandgrow.plantdetails

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.sowandgrow.Plants
import com.example.sowandgrow.R

class SnakePlant : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_snake_plant)

        val plant = intent.getParcelableExtra<Plants> ("plants")
        if (plant !=null){
            val textView1: TextView = findViewById(R.id.plant_name_view)
            val textView2:TextView=findViewById(R.id.plant_type)
            val imageView : ImageView = findViewById(R.id.plant_image_view)
            textView1.text = plant.name
            textView2.text=plant.name
            imageView.setImageResource(plant.image)
        }
    }
}