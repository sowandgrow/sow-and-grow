package com.example.sowandgrow

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sowandgrow.plantdetails.SnakePlant

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
        plantsList.add(Plants(R.drawable.aloevera,"Aloevera Plant"))
        plantsList.add(Plants(R.drawable.holybasil01,"Holy Basil"))
        plantsList.add(Plants(R.drawable.lavender01,"Lavender Plant"))
        plantsList.add(Plants(R.drawable.jade01,"Jade Plant"))
        plantsList.add(Plants(R.drawable.luckybamboo01,"Lucky Bamboo Plant"))
        plantsList.add(Plants(R.drawable.marigold01,"Marigold Plant"))
        plantsList.add(Plants(R.drawable.rubberplant01,"Rubber Plant"))
        plantsList.add(Plants(R.drawable.hibiscus01,"Hibiscus Plant"))
        plantsList.add(Plants(R.drawable.philodendron03,"Philodendron Plant"))
        plantsList.add(Plants(R.drawable.roseus,"Roseus Plant"))
        plantsList.add(Plants(R.drawable.weepingfig02,"Weeping fig Plant"))
        plantsList.add(Plants(R.drawable.zzplant02,"Zamioculcas zamiifolia Plant"))





        plantsAdapter = PlantsAdapter(plantsList)
        recyclerView.adapter = plantsAdapter

        plantsAdapter.onItemClick={
            val intent= Intent(this,SnakePlant::class.java)
            intent.putExtra("plants",it)
            startActivity(intent)

        }


    }
}