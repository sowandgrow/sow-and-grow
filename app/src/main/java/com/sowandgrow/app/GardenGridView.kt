package com.sowandgrow.app

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sowandgrow.app.plantdetails.AglaonemaPlant
import com.sowandgrow.app.plantdetails.AloeveraPlant
import com.sowandgrow.app.plantdetails.ArboricolaPlant
import com.sowandgrow.app.plantdetails.ArecaPlant
import com.sowandgrow.app.plantdetails.ArrowheadVine
import com.sowandgrow.app.plantdetails.AshwagandhaPlant
import com.sowandgrow.app.plantdetails.BegoniaPlant
import com.sowandgrow.app.plantdetails.BetelPlant
import com.sowandgrow.app.plantdetails.BonsaiPlant
import com.sowandgrow.app.plantdetails.BostonFern
import com.sowandgrow.app.plantdetails.BougainvilleaPlant
import com.sowandgrow.app.plantdetails.CactusPlant
import com.sowandgrow.app.plantdetails.CaladiumPlant
import com.sowandgrow.app.plantdetails.CalatheasPlant
import com.sowandgrow.app.plantdetails.CastironPlant
import com.sowandgrow.app.plantdetails.CrotonPLant
import com.sowandgrow.app.plantdetails.DevilivyPlant
import com.sowandgrow.app.plantdetails.DracaenaPlant
import com.sowandgrow.app.plantdetails.DragonTree
import com.sowandgrow.app.plantdetails.Englishivy
import com.sowandgrow.app.plantdetails.FiddleleafigPlant
import com.sowandgrow.app.plantdetails.HeucheraPlant
import com.sowandgrow.app.plantdetails.HibiscusPlant
import com.sowandgrow.app.plantdetails.HolyBasil
import com.sowandgrow.app.plantdetails.ImpatiensPlant
import com.sowandgrow.app.plantdetails.InchPlant
import com.sowandgrow.app.plantdetails.JadePlant
import com.sowandgrow.app.plantdetails.JasminePlant
import com.sowandgrow.app.plantdetails.LaceleafPlant
import com.sowandgrow.app.plantdetails.LavenderPlant
import com.sowandgrow.app.plantdetails.Lemongrass
import com.sowandgrow.app.plantdetails.LobeliaPlant
import com.sowandgrow.app.plantdetails.LuckyBamboo
import com.sowandgrow.app.plantdetails.MandevillaPlant
import com.sowandgrow.app.plantdetails.MarigoldPlant
import com.sowandgrow.app.plantdetails.MoneyPlant
import com.sowandgrow.app.plantdetails.Neem
import com.sowandgrow.app.plantdetails.NorfolkPine
import com.sowandgrow.app.plantdetails.PeacelilyPlant
import com.sowandgrow.app.plantdetails.PhilodendronPlant
import com.sowandgrow.app.plantdetails.PothosPlant
import com.sowandgrow.app.plantdetails.RosePlant
import com.sowandgrow.app.plantdetails.RoseusPlant
import com.sowandgrow.app.plantdetails.RubberPlant
import com.sowandgrow.app.plantdetails.SnakePlant
import com.sowandgrow.app.plantdetails.SpiderPlant
import com.sowandgrow.app.plantdetails.Sweetalyssum
import com.sowandgrow.app.plantdetails.SwisscheesePlant
import com.sowandgrow.app.plantdetails.SwordfernPlant
import com.sowandgrow.app.plantdetails.TillandsiaPlant
import com.sowandgrow.app.plantdetails.ToreniaPlant
import com.sowandgrow.app.plantdetails.VerbenaPlant
import com.sowandgrow.app.plantdetails.ViolasPlant
import com.sowandgrow.app.plantdetails.WeepingfigPlant
import com.sowandgrow.app.plantdetails.ZebraPlant
import com.sowandgrow.app.plantdetails.ZzPlant


class GardenGridView : AppCompatActivity() {

    private lateinit var recyclerView2: RecyclerView
    private lateinit var gardenList: ArrayList<Garden>
    private lateinit var gardenAdapter: GardenAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_garden_grid_view)
        init()
    }

    private fun init() {
        recyclerView2 = findViewById(R.id.recyclerView2)
        recyclerView2.setHasFixedSize(true)
        recyclerView2.layoutManager = GridLayoutManager(this, 2)

        gardenList = ArrayList()
        addDataToList()

        gardenAdapter = GardenAdapter(gardenList) { clickedGarden ->
            when (clickedGarden.name) {
                "Ashwagandha" -> {
                    val intent = Intent(this, AshwagandhaPlant::class.java)
                    // Customize the intent as needed
                    startActivity(intent)
                }
                "Aglaonema Plant" -> {
                    val intent = Intent(this, AglaonemaPlant::class.java)
                    // Customize the intent as needed
                    startActivity(intent)
                }
                "Aloevera Plant" -> {
                    val intent = Intent(this, AloeveraPlant::class.java)
                    // Customize the intent as needed
                    startActivity(intent)
                }
                "Arboricola Plant" -> {
                    val intent = Intent(this, ArboricolaPlant::class.java)
                    // Customize the intent as needed
                    startActivity(intent)
                }
                "Areca Plant" -> {
                    val intent = Intent(this, ArecaPlant::class.java)
                    // Customize the intent as needed
                    startActivity(intent)
                }
                "Arrowhead Vine" -> {
                    val intent = Intent(this, ArrowheadVine::class.java)
                    // Customize the intent as needed
                    startActivity(intent)
                }
                "Begonia Plant" -> {
                    val intent = Intent(this, BegoniaPlant::class.java)
                    // Customize the intent as needed
                    startActivity(intent)
                }
                "Betel Plant" -> {
                    val intent = Intent(this, BetelPlant::class.java)
                    // Customize the intent as needed
                    startActivity(intent)
                }
                "Boston Fern" -> {
                    val intent = Intent(this, BostonFern::class.java)
                    // Customize the intent as needed
                    startActivity(intent)
                }
                "Bonsai Plant" -> {
                    val intent = Intent(this, BonsaiPlant::class.java)
                    // Customize the intent as needed
                    startActivity(intent)
                }
                "Bougainvillea Plant" -> {
                    val intent = Intent(this, BougainvilleaPlant::class.java)
                    // Customize the intent as needed
                    startActivity(intent)
                }
                "Caladium Plant" -> {
                    val intent = Intent(this, CaladiumPlant::class.java)
                    // Customize the intent as needed
                    startActivity(intent)
                }
                "Calatheas Plant" -> {
                    val intent = Intent(this, CalatheasPlant::class.java)
                    // Customize the intent as needed
                    startActivity(intent)
                }
                "Croton" -> {
                    val intent = Intent(this, CrotonPLant::class.java)
                    // Customize the intent as needed
                    startActivity(intent)
                }
                "Cactus Plant" -> {
                    val intent = Intent(this, CactusPlant::class.java)
                    // Customize the intent as needed
                    startActivity(intent)
                }
                "Cast Iron Plant" -> {
                    val intent = Intent(this, CastironPlant::class.java)
                    // Customize the intent as needed
                    startActivity(intent)
                }
                "Dragon Tree" -> {
                    val intent = Intent(this, DragonTree::class.java)
                    // Customize the intent as needed
                    startActivity(intent)
                }
                "Devil's Ivy Plant" -> {
                    val intent = Intent(this, DevilivyPlant::class.java)
                    // Customize the intent as needed
                    startActivity(intent)
                }
                "Dracaena Plant" -> {
                    val intent = Intent(this, DracaenaPlant::class.java)
                    // Customize the intent as needed
                    startActivity(intent)
                }
                "English Ivy Plant" -> {
                    val intent = Intent(this, Englishivy::class.java)
                    // Customize the intent as needed
                    startActivity(intent)
                }
                "Heuchera Plant" -> {
                    val intent = Intent(this, HeucheraPlant::class.java)
                    // Customize the intent as needed
                    startActivity(intent)
                }
                "Holy Basil" -> {
                    val intent = Intent(this, HolyBasil::class.java)
                    // Customize the intent as needed
                    startActivity(intent)
                }
                "Hibiscus Plant" -> {
                    val intent = Intent(this, HibiscusPlant::class.java)
                    // Customize the intent as needed
                    startActivity(intent)
                }
                "Impatiens Plant" -> {
                    val intent = Intent(this, ImpatiensPlant::class.java)
                    // Customize the intent as needed
                    startActivity(intent)
                }
                "InchPlant" -> {
                    val intent = Intent(this, InchPlant::class.java)
                    // Customize the intent as needed
                    startActivity(intent)
                }
                "Jade Plant" -> {
                    val intent = Intent(this, JadePlant::class.java)
                    // Customize the intent as needed
                    startActivity(intent)
                }
                "Jasmine Plant" -> {
                    val intent = Intent(this, JasminePlant::class.java)
                    // Customize the intent as needed
                    startActivity(intent)
                }
                "Lavender Plant" -> {
                    val intent = Intent(this, LavenderPlant::class.java)
                    // Customize the intent as needed
                    startActivity(intent)
                }
                "Laceleaf" -> {
                    val intent = Intent(this, LaceleafPlant::class.java)
                    // Customize the intent as needed
                    startActivity(intent)
                }
                "Fiddle Leaf Fig" -> {
                    val intent = Intent(this, FiddleleafigPlant::class.java)
                    // Customize the intent as needed
                    startActivity(intent)
                }
                "Lemongrass" -> {
                    val intent = Intent(this, Lemongrass::class.java)
                    // Customize the intent as needed
                    startActivity(intent)
                }
                "Lobelia Plant" -> {
                    val intent = Intent(this, LobeliaPlant::class.java)
                    // Customize the intent as needed
                    startActivity(intent)
                }
                "Lucky Bamboo Plant" -> {
                    val intent = Intent(this, LuckyBamboo::class.java)
                    // Customize the intent as needed
                    startActivity(intent)
                }
                "Marigold Plant" -> {
                    val intent = Intent(this, MarigoldPlant::class.java)
                    // Customize the intent as needed
                    startActivity(intent)
                }
                "Mandevilla Plant" -> {
                    val intent = Intent(this, MandevillaPlant::class.java)
                    // Customize the intent as needed
                    startActivity(intent)
                }
                "Money Plant" -> {
                    val intent = Intent(this, MoneyPlant::class.java)
                    // Customize the intent as needed
                    startActivity(intent)
                }
                "PeaceLily Plant" -> {
                    val intent = Intent(this, PeacelilyPlant::class.java)
                    // Customize the intent as needed
                    startActivity(intent)
                }
                "Neem" -> {
                    val intent = Intent(this, Neem::class.java)
                    // Customize the intent as needed
                    startActivity(intent)
                }
                "Philodendron Plant" -> {
                    val intent = Intent(this, PhilodendronPlant::class.java)
                    // Customize the intent as needed
                    startActivity(intent)
                }
                "Norfolk Pine" -> {
                    val intent = Intent(this, NorfolkPine::class.java)
                    // Customize the intent as needed
                    startActivity(intent)
                }
                "Pothos" -> {
                    val intent = Intent(this, PothosPlant::class.java)
                    // Customize the intent as needed
                    startActivity(intent)
                }
                "Roseus Plant" -> {
                    val intent = Intent(this, RoseusPlant::class.java)
                    // Customize the intent as needed
                    startActivity(intent)
                }
                "Rose Plant" -> {
                    val intent = Intent(this, RosePlant::class.java)
                    // Customize the intent as needed
                    startActivity(intent)
                }
                "Rubber Plant" -> {
                    val intent = Intent(this, RubberPlant::class.java)
                    // Customize the intent as needed
                    startActivity(intent)
                }
                "Spider Plant" -> {
                    val intent = Intent(this, SpiderPlant::class.java)
                    // Customize the intent as needed
                    startActivity(intent)
                }
                "Snake Plant" -> {
                    val intent = Intent(this, SnakePlant::class.java)
                    // Customize the intent as needed
                    startActivity(intent)
                }
                "Sweet Alyssum" -> {
                    val intent = Intent(this, Sweetalyssum::class.java)
                    // Customize the intent as needed
                    startActivity(intent)
                }
                "Swiss Cheese Plant" -> {
                    val intent = Intent(this, SwisscheesePlant::class.java)
                    // Customize the intent as needed
                    startActivity(intent)
                }
                "Air Plant" -> {
                    val intent = Intent(this, TillandsiaPlant::class.java)
                    // Customize the intent as needed
                    startActivity(intent)
                }
                "Sword Fern" -> {
                    val intent = Intent(this, SwordfernPlant::class.java)
                    // Customize the intent as needed
                    startActivity(intent)
                }
                "Torenia Plant" -> {
                    val intent = Intent(this, ToreniaPlant::class.java)
                    // Customize the intent as needed
                    startActivity(intent)
                }
                "Verbena Plant" -> {
                    val intent = Intent(this, VerbenaPlant::class.java)
                    // Customize the intent as needed
                    startActivity(intent)
                }
                "Violas Plant" -> {
                    val intent = Intent(this, ViolasPlant::class.java)
                    // Customize the intent as needed
                    startActivity(intent)
                }
                "Weeping Fig Plant" -> {
                    val intent = Intent(this, WeepingfigPlant::class.java)
                    // Customize the intent as needed
                    startActivity(intent)
                }
                "Zebra Plant" -> {
                    val intent = Intent(this, ZebraPlant::class.java)
                    // Customize the intent as needed
                    startActivity(intent)
                }
                "ZZ Plant" -> {
                    val intent = Intent(this, ZzPlant::class.java)
                    // Customize the intent as needed
                    startActivity(intent)
                }


                else -> {
                    // Handle the case where the clicked garden doesn't have a specific activity
                }
            }
        }

        recyclerView2.adapter = gardenAdapter
    }

    private fun addDataToList() {

        gardenList.add(Garden(R.drawable.aglaonema, "Aglaonema Plant"))
        gardenList.add(Garden(R.drawable.aloevera, "Aloevera Plant"))
        gardenList.add(Garden(R.drawable.arboricolaplant, "Arboricola Plant"))
        gardenList.add(Garden(R.drawable.arecapalm, "Areca Plant"))
        gardenList.add(Garden(R.drawable.arrowheadvine, "Arrowhead Vine"))
        gardenList.add(Garden(R.drawable.ashwagandha, "Ashwagandha"))
        gardenList.add(Garden(R.drawable.begonia, "Begonia Plant"))
        gardenList.add(Garden(R.drawable.betel, "Betel Plant"))
        gardenList.add(Garden(R.drawable.bonsai, "Bonsai Plant"))
        gardenList.add(Garden(R.drawable.bostonfern, "Boston Fern"))
        gardenList.add(Garden(R.drawable.bougainvillea, "Bougainvillea Plant"))
        gardenList.add(Garden(R.drawable.caladiumplant, "Caladium Plant"))
        gardenList.add(Garden(R.drawable.calatheaplant, "Calatheas Plant"))
        gardenList.add(Garden(R.drawable.cactus1, "Cactus Plant"))
        gardenList.add(Garden(R.drawable.castironplant, "Cast Iron Plant"))
        gardenList.add(Garden(R.drawable.croton, "Croton"))
        gardenList.add(Garden(R.drawable.devilivy, "Devil's Ivy Plant"))
        gardenList.add(Garden(R.drawable.dragontreeplant, "Dragon Tree"))
        gardenList.add(Garden(R.drawable.dracaenaplant, "Dracaena Plant"))
        gardenList.add(Garden(R.drawable.englishivy, "English Ivy Plant"))
        gardenList.add(Garden(R.drawable.fiddleleaffig, "Fiddle Leaf Fig"))
        gardenList.add(Garden(R.drawable.heucheraplant, "Heuchera Plant"))
        gardenList.add(Garden(R.drawable.hibiscus01, "Hibiscus Plant"))
        gardenList.add(Garden(R.drawable.holybasil01, "Holy Basil"))
        gardenList.add(Garden(R.drawable.impatienplant, "Impatiens Plant"))
        gardenList.add(Garden(R.drawable.inchplant, "InchPlant"))
        gardenList.add(Garden(R.drawable.jade01, "Jade Plant"))
        gardenList.add(Garden(R.drawable.jasmine, "Jasmine Plant"))
        gardenList.add(Garden(R.drawable.laceleaf, "Laceleaf"))
        gardenList.add(Garden(R.drawable.lavender01, "Lavender Plant"))
        gardenList.add(Garden(R.drawable.lemongrass, "Lemongrass"))
        gardenList.add(Garden(R.drawable.lobeliaplant, "Lobelia Plant"))
        gardenList.add(Garden(R.drawable.luckybamboo01, "Lucky Bamboo Plant"))
        gardenList.add(Garden(R.drawable.marigold01, "Marigold Plant"))
        gardenList.add(Garden(R.drawable.mandevilla, "Mandevilla Plant"))
        gardenList.add(Garden(R.drawable.moneyplant, "Money Plant"))
        gardenList.add(Garden(R.drawable.neem, "Neem"))
        gardenList.add(Garden(R.drawable.norfolkpine, "Norfolk Pine"))
        gardenList.add(Garden(R.drawable.peacelily, "PeaceLily Plant"))
        gardenList.add(Garden(R.drawable.philodendron03, "Philodendron Plant"))
        gardenList.add(Garden(R.drawable.pothos, "Pothos"))
        gardenList.add(Garden(R.drawable.roseus, "Roseus Plant"))
        gardenList.add(Garden(R.drawable.rose, "Rose Plant"))
        gardenList.add(Garden(R.drawable.rubberplant01, "Rubber Plant"))
        gardenList.add(Garden(R.drawable.snakeplant, "Snake Plant"))
        gardenList.add(Garden(R.drawable.spiderplant, "Spider Plant"))
        gardenList.add(Garden(R.drawable.sweetalyssum, "Sweet Alyssum"))
        gardenList.add(Garden(R.drawable.swisscheese, "Swiss Cheese Plant"))
        gardenList.add(Garden(R.drawable.swordfern, "Sword Fern"))
        gardenList.add(Garden(R.drawable.tillandsia, "Air Plant"))
        gardenList.add(Garden(R.drawable.toreniaplant, "Torenia Plant"))
        gardenList.add(Garden(R.drawable.verbena, "Verbena Plant"))
        gardenList.add(Garden(R.drawable.violas, "Violas Plant"))
        gardenList.add(Garden(R.drawable.weepingfig02, "Weeping Fig Plant"))
        gardenList.add(Garden(R.drawable.zzplant02, "ZZ Plant"))
        gardenList.add(Garden(R.drawable.zebraplant,"Zebra Plant"))
    }
}
