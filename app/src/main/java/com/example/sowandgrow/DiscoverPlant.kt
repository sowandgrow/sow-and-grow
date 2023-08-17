package com.example.sowandgrow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class DiscoverPlant : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var plantsList : ArrayList<Plants>
    private lateinit var plantsAdapter: PlantsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_discover_plant)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)

        plantsList = ArrayList()

        plantsList.add(Plants(R.drawable.snakeplant,"Snake Plant"))
        plantsList.add(Plants(R.drawable.arecapalm,"Areca Plant"))
        plantsList.add(Plants(R.drawable.arrowheadvine,"Arrowhead Vine"))
        plantsList.add(Plants(R.drawable.bostonfern,"Boston Fern"))
        plantsList.add(Plants(R.drawable.croton,"Croton"))
        plantsList.add(Plants(R.drawable.gereniumplant,"Gerenium Plant"))
        plantsList.add(Plants(R.drawable.moneyplant,"Money Plant"))
        plantsList.add(Plants(R.drawable.spiderplant,"Spider Plant"))


        plantsAdapter = PlantsAdapter(plantsList)
        recyclerView.adapter = plantsAdapter

    }
}