package com.example.sowandgrow

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class GardenGridView : AppCompatActivity() {

    private lateinit var recyclerView2: RecyclerView
    private lateinit var gardenList: ArrayList<Garden>
    private lateinit var gardenAdapter: GardenAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        recyclerView2 = findViewById(R.id.recyclerView2)
        recyclerView2.setHasFixedSize(true)
        recyclerView2.layoutManager = GridLayoutManager(this, 2)

        gardenList = ArrayList()
        addDataToList()

        gardenAdapter = GardenAdapter(gardenList)
        recyclerView2.adapter = gardenAdapter
    }

    private fun addDataToList() {
        gardenList.add(Garden(R.drawable.ashwagandha, "Ashwagandha Garden"))
        gardenList.add(Garden(R.drawable.betel, "Betel Garden"))
        gardenList.add(Garden(R.drawable.bonsai, "Bonsai Garden"))
    }
}