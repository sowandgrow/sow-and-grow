package com.example.sowandgrow

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sowandgrow.plantdetails.AloeveraPlant
import com.example.sowandgrow.plantdetails.ArecaPlant
import com.example.sowandgrow.plantdetails.ArrowheadVine
import com.example.sowandgrow.plantdetails.AshwagandhaPlant
import com.example.sowandgrow.plantdetails.BetelPlant
import com.example.sowandgrow.plantdetails.BonsaiPlant
import com.example.sowandgrow.plantdetails.BostonFern
import com.example.sowandgrow.plantdetails.BougainvilleaPlant
import com.example.sowandgrow.plantdetails.CrotonPLant
import com.example.sowandgrow.plantdetails.HibiscusPlant
import com.example.sowandgrow.plantdetails.HolyBasil
import com.example.sowandgrow.plantdetails.JadePlant
import com.example.sowandgrow.plantdetails.JasminePlant
import com.example.sowandgrow.plantdetails.LaceleafPlant
import com.example.sowandgrow.plantdetails.LavenderPlant
import com.example.sowandgrow.plantdetails.Lemongrass
import com.example.sowandgrow.plantdetails.LuckyBamboo
import com.example.sowandgrow.plantdetails.MarigoldPlant
import com.example.sowandgrow.plantdetails.Mint
import com.example.sowandgrow.plantdetails.MoneyPlant
import com.example.sowandgrow.plantdetails.Neem
import com.example.sowandgrow.plantdetails.PeacelilyPlant
import com.example.sowandgrow.plantdetails.PhilodendronPlant
import com.example.sowandgrow.plantdetails.RosePlant
import com.example.sowandgrow.plantdetails.RoseusPlant
import com.example.sowandgrow.plantdetails.RubberPlant
import com.example.sowandgrow.plantdetails.SnakePlant
import com.example.sowandgrow.plantdetails.SpiderPlant
import com.example.sowandgrow.plantdetails.WeepingfigPlant
import com.example.sowandgrow.plantdetails.ZzPlant

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

        plantsList.add(Plants(R.drawable.snakeplant, "Snake Plant"))
        plantsList.add(Plants(R.drawable.arecapalm, "Areca Plant"))
        plantsList.add(Plants(R.drawable.arrowheadvine, "Arrowhead Vine"))
        plantsList.add(Plants(R.drawable.bostonfern, "Boston Fern"))
        plantsList.add(Plants(R.drawable.croton, "Croton"))
        plantsList.add(Plants(R.drawable.ashwagandha, "Ashwagandha"))
        plantsList.add(Plants(R.drawable.moneyplant, "Money Plant"))
        plantsList.add(Plants(R.drawable.spiderplant, "Spider Plant"))
        plantsList.add(Plants(R.drawable.aloevera, "Aloevera Plant"))
        plantsList.add(Plants(R.drawable.holybasil01, "Holy Basil"))
        plantsList.add(Plants(R.drawable.lavender01, "Lavender Plant"))
        plantsList.add(Plants(R.drawable.jade01, "Jade Plant"))
        plantsList.add(Plants(R.drawable.luckybamboo01, "Lucky Bamboo Plant"))
        plantsList.add(Plants(R.drawable.marigold01, "Marigold Plant"))
        plantsList.add(Plants(R.drawable.rubberplant01, "Rubber Plant"))
        plantsList.add(Plants(R.drawable.hibiscus01, "Hibiscus Plant"))
        plantsList.add(Plants(R.drawable.philodendron03, "Philodendron Plant"))
        plantsList.add(Plants(R.drawable.roseus, "Roseus Plant"))
        plantsList.add(Plants(R.drawable.weepingfig02, "Weeping fig Plant"))
        plantsList.add(Plants(R.drawable.zzplant02, "ZZ Plant"))
        plantsList.add(Plants(R.drawable.betel, "Betel Plant"))
        plantsList.add(Plants(R.drawable.bonsai, "Bonsai Plant"))
        plantsList.add(Plants(R.drawable.bougainvillea, "Bougainvillea Plant"))
        plantsList.add(Plants(R.drawable.jasmine, "Jasmine Plant"))
        plantsList.add(Plants(R.drawable.laceleaf, "Lace-leaf"))
        plantsList.add(Plants(R.drawable.lemongrass, "Lemongrass"))
        plantsList.add(Plants(R.drawable.mint, "Mint"))
        plantsList.add(Plants(R.drawable.neem, "Neem"))
        plantsList.add(Plants(R.drawable.peacelily, "PeaceLily Plant"))
        plantsList.add(Plants(R.drawable.rose, "Rose Plant"))



        plantsAdapter = PlantsAdapter(plantsList)
        recyclerView.adapter = plantsAdapter

        plantsAdapter.onItemClick = { clickedPlant ->
            when (clickedPlant.name) {
                "Snake Plant" -> {
                    val intent = Intent(this, SnakePlant::class.java)
                    intent.putExtra("plants", clickedPlant)
                    startActivity(intent)
                }
                "Areca Plant" -> {
                    val intent = Intent(this, ArecaPlant::class.java)
                    intent.putExtra("plants", clickedPlant)
                    startActivity(intent)
                }
                "Arrowhead Vine" -> {
                    val intent = Intent(this, ArrowheadVine::class.java)
                    intent.putExtra("plants", clickedPlant)
                    startActivity(intent)
                }
                "Boston Fern" -> {
                    val intent = Intent(this, BostonFern::class.java)
                    intent.putExtra("plants", clickedPlant)
                    startActivity(intent)
                }
                "Croton" -> {
                    val intent = Intent(this, CrotonPLant::class.java)
                    intent.putExtra("plants", clickedPlant)
                    startActivity(intent)
                }
                "Ashwagandha" -> {
                    val intent = Intent(this, AshwagandhaPlant::class.java)
                    intent.putExtra("plants", clickedPlant)
                    startActivity(intent)
                }
                "Money Plant" -> {
                    val intent = Intent(this, MoneyPlant::class.java)
                    intent.putExtra("plants", clickedPlant)
                    startActivity(intent)
                }
                "Spider Plant" -> {
                    val intent = Intent(this, SpiderPlant::class.java)
                    intent.putExtra("plants", clickedPlant)
                    startActivity(intent)
                }
                "Aloevera Plant" -> {
                    val intent = Intent(this, AloeveraPlant::class.java)
                    intent.putExtra("plants", clickedPlant)
                    startActivity(intent)
                }
                "Holy Basil" -> {
                    val intent = Intent(this, HolyBasil::class.java)
                    intent.putExtra("plants", clickedPlant)
                    startActivity(intent)
                }
                "Lavender Plant" -> {
                    val intent = Intent(this, LavenderPlant::class.java)
                    intent.putExtra("plants", clickedPlant)
                    startActivity(intent)
                }
                "Jade Plant" -> {
                    val intent = Intent(this, JadePlant::class.java)
                    intent.putExtra("plants", clickedPlant)
                    startActivity(intent)
                }
                "Lucky Bamboo Plant" -> {
                    val intent = Intent(this, LuckyBamboo::class.java)
                    intent.putExtra("plants", clickedPlant)
                    startActivity(intent)
                }
                "Marigold Plant" -> {
                    val intent = Intent(this, MarigoldPlant::class.java)
                    intent.putExtra("plants", clickedPlant)
                    startActivity(intent)
                }
                "Rubber Plant" -> {
                    val intent = Intent(this, RubberPlant::class.java)
                    intent.putExtra("plants", clickedPlant)
                    startActivity(intent)
                }
                "Hibiscus Plant" -> {
                    val intent = Intent(this, HibiscusPlant::class.java)
                    intent.putExtra("plants", clickedPlant)
                    startActivity(intent)
                }
                "Philodendron Plant" -> {
                    val intent = Intent(this, PhilodendronPlant::class.java)
                    intent.putExtra("plants", clickedPlant)
                    startActivity(intent)
                }"Roseus Plant" -> {
                    val intent = Intent(this, RoseusPlant::class.java)
                    intent.putExtra("plants", clickedPlant)
                    startActivity(intent)
                }"Weeping fig Plant" -> {
                    val intent = Intent(this, WeepingfigPlant::class.java)
                    intent.putExtra("plants", clickedPlant)
                    startActivity(intent)
                }"ZZ Plant" -> {
                    val intent = Intent(this, ZzPlant::class.java)
                    intent.putExtra("plants", clickedPlant)
                    startActivity(intent)
                }
                "Betel Plant" -> {
                    val intent = Intent(this, BetelPlant::class.java)
                    intent.putExtra("plants", clickedPlant)
                    startActivity(intent)
                }
                "Bonsai Plant" -> {
                    val intent = Intent(this, BonsaiPlant::class.java)
                    intent.putExtra("plants", clickedPlant)
                    startActivity(intent)
                }
                "Bougainvillea" -> {
                    val intent = Intent(this, BougainvilleaPlant::class.java)
                    intent.putExtra("plants", clickedPlant)
                    startActivity(intent)
                }
                "Jasmine" -> {
                    val intent = Intent(this, JasminePlant::class.java)
                    intent.putExtra("plants", clickedPlant)
                    startActivity(intent)
                }
                "Lace-leaf " -> {
                    val intent = Intent(this, LaceleafPlant::class.java)
                    intent.putExtra("plants", clickedPlant)
                    startActivity(intent)
                }
                "Lemongrass" -> {
                    val intent = Intent(this, Lemongrass::class.java)
                    intent.putExtra("plants", clickedPlant)
                    startActivity(intent)
                }
                "Mint" -> {
                    val intent = Intent(this, Mint::class.java)
                    intent.putExtra("plants", clickedPlant)
                    startActivity(intent)
                }
                "Neem" -> {
                    val intent = Intent(this, Neem::class.java)
                    intent.putExtra("plants", clickedPlant)
                    startActivity(intent)
                }
                "PeaceLily Plant" -> {
                    val intent = Intent(this, PeacelilyPlant::class.java)
                    intent.putExtra("plants", clickedPlant)
                    startActivity(intent)
                }
                "Rose Plant" -> {
                    val intent = Intent(this, RosePlant::class.java)
                    intent.putExtra("plants", clickedPlant)
                    startActivity(intent)
                }
            }
        }
    }
}
