package com.sowandgrow.app

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sowandgrow.app.Plants
import com.sowandgrow.app.PlantsAdapter
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
import com.sowandgrow.app.plantdetails.HydrangeaPlant
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
import com.sowandgrow.app.plantdetails.Mint
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
import java.util.Locale

class DiscoverPlant : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var plantsList : ArrayList<Plants>
    private lateinit var plantsAdapter: PlantsAdapter
    private lateinit var searchView: SearchView

    private var noPlantFoundToast: Toast? = null
    private var initialSearchAttempted = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_discover_plant)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)


        plantsList = ArrayList()

        plantsList.add(Plants(R.drawable.aglaonema, "Aglaonema Plant"))
        plantsList.add(Plants(R.drawable.aloevera, "Aloevera Plant"))
        plantsList.add(Plants(R.drawable.arboricolaplant, "Arboricola Plant"))
        plantsList.add(Plants(R.drawable.arecapalm, "Areca Plant"))
        plantsList.add(Plants(R.drawable.arrowheadvine, "Arrowhead Vine"))
        plantsList.add(Plants(R.drawable.ashwagandha, "Ashwagandha"))
        plantsList.add(Plants(R.drawable.begonia, "Begonia Plant"))
        plantsList.add(Plants(R.drawable.betel, "Betel Plant"))
        plantsList.add(Plants(R.drawable.bonsai, "Bonsai Plant"))
        plantsList.add(Plants(R.drawable.bostonfern, "Boston Fern"))
        plantsList.add(Plants(R.drawable.bougainvillea, "Bougainvillea Plant"))
        plantsList.add(Plants(R.drawable.caladiumplant, "Caladium Plant"))
        plantsList.add(Plants(R.drawable.calatheaplant, "Calatheas Plant"))
        plantsList.add(Plants(R.drawable.cactus1, "Cactus Plant"))
        plantsList.add(Plants(R.drawable.castironplant, "Cast Iron Plant"))
        plantsList.add(Plants(R.drawable.croton, "Croton"))
        plantsList.add(Plants(R.drawable.devilivy, "Devil's Ivy Plant"))
        plantsList.add(Plants(R.drawable.dragontreeplant, "Dragon Tree"))
        plantsList.add(Plants(R.drawable.dracaenaplant, "Dracaena Plant"))
        plantsList.add(Plants(R.drawable.englishivy, "English Ivy Plant"))
        plantsList.add(Plants(R.drawable.fiddleleaffig, "Fiddle Leaf Fig"))
        plantsList.add(Plants(R.drawable.heucheraplant, "Heuchera Plant"))
        plantsList.add(Plants(R.drawable.hibiscus01, "Hibiscus Plant"))
        plantsList.add(Plants(R.drawable.holybasil01, "Holy Basil"))
        plantsList.add(Plants(R.drawable.impatienplant, "Impatiens Plant"))
        plantsList.add(Plants(R.drawable.inchplant, "InchPlant"))
        plantsList.add(Plants(R.drawable.jade01, "Jade Plant"))
        plantsList.add(Plants(R.drawable.jasmine, "Jasmine Plant"))
        plantsList.add(Plants(R.drawable.laceleaf, "Laceleaf"))
        plantsList.add(Plants(R.drawable.lavender01, "Lavender Plant"))
        plantsList.add(Plants(R.drawable.lemongrass, "Lemongrass"))
        plantsList.add(Plants(R.drawable.lobeliaplant, "Lobelia Plant"))
        plantsList.add(Plants(R.drawable.luckybamboo01, "Lucky Bamboo Plant"))
        plantsList.add(Plants(R.drawable.marigold01, "Marigold Plant"))
        plantsList.add(Plants(R.drawable.mandevilla, "Mandevilla Plant"))
        plantsList.add(Plants(R.drawable.moneyplant, "Money Plant"))
        plantsList.add(Plants(R.drawable.neem, "Neem"))
        plantsList.add(Plants(R.drawable.norfolkpine, "Norfolk Pine"))
        plantsList.add(Plants(R.drawable.peacelily, "PeaceLily Plant"))
        plantsList.add(Plants(R.drawable.philodendron03, "Philodendron Plant"))
        plantsList.add(Plants(R.drawable.pothos, "Pothos"))
        plantsList.add(Plants(R.drawable.roseus, "Roseus Plant"))
        plantsList.add(Plants(R.drawable.rose, "Rose Plant"))
        plantsList.add(Plants(R.drawable.rubberplant01, "Rubber Plant"))
        plantsList.add(Plants(R.drawable.snakeplant, "Snake Plant"))
        plantsList.add(Plants(R.drawable.spiderplant, "Spider Plant"))
        plantsList.add(Plants(R.drawable.sweetalyssum, "Sweet Alyssum"))
        plantsList.add(Plants(R.drawable.swisscheese, "Swiss Cheese Plant"))
        plantsList.add(Plants(R.drawable.swordfern, "Sword Fern"))
        plantsList.add(Plants(R.drawable.tillandsia, "Air Plant"))
        plantsList.add(Plants(R.drawable.toreniaplant, "Torenia Plant"))
        plantsList.add(Plants(R.drawable.verbena, "Verbena Plant"))
        plantsList.add(Plants(R.drawable.violas, "Violas Plant"))
        plantsList.add(Plants(R.drawable.weepingfig02, "Weeping Fig Plant"))
        plantsList.add(Plants(R.drawable.zzplant02, "ZZ Plant"))
        plantsList.add(Plants(R.drawable.zebraplant, "Zebra Plant"))


        plantsAdapter = PlantsAdapter(plantsList)
        recyclerView.adapter = plantsAdapter

        searchView = findViewById(R.id.searchView)
        searchView.clearFocus()
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterList(newText)
                return true
            }
        })

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
                }

                "Roseus Plant" -> {
                    val intent = Intent(this, RoseusPlant::class.java)
                    intent.putExtra("plants", clickedPlant)
                    startActivity(intent)
                }

                "Weeping Fig Plant" -> {
                    val intent = Intent(this, WeepingfigPlant::class.java)
                    intent.putExtra("plants", clickedPlant)
                    startActivity(intent)
                }

                "ZZ Plant" -> {
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

                "Bougainvillea Plant" -> {
                    val intent = Intent(this, BougainvilleaPlant::class.java)
                    intent.putExtra("plants", clickedPlant)
                    startActivity(intent)
                }

                "Jasmine Plant" -> {
                    val intent = Intent(this, JasminePlant::class.java)
                    intent.putExtra("plants", clickedPlant)
                    startActivity(intent)
                }

                "Laceleaf" -> {
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

                "Cactus Plant" -> {
                    val intent = Intent(this, CactusPlant::class.java)
                    intent.putExtra("plants", clickedPlant)
                    startActivity(intent)
                }

                "Verbena Plant" -> {
                    val intent = Intent(this, VerbenaPlant::class.java)
                    intent.putExtra("plants", clickedPlant)
                    startActivity(intent)
                }

                "Devil's Ivy Plant" -> {
                    val intent = Intent(this, DevilivyPlant::class.java)
                    intent.putExtra("plants", clickedPlant)
                    startActivity(intent)
                }

                "Fiddle Leaf Fig" -> {
                    val intent = Intent(this, FiddleleafigPlant::class.java)
                    intent.putExtra("plants", clickedPlant)
                    startActivity(intent)
                }

                "English Ivy Plant" -> {
                    val intent = Intent(this, Englishivy::class.java)
                    intent.putExtra("plants", clickedPlant)
                    startActivity(intent)
                }

                "Pothos" -> {
                    val intent = Intent(this, PothosPlant::class.java)
                    intent.putExtra("plants", clickedPlant)
                    startActivity(intent)
                }

                "Aglaonema Plant" -> {
                    val intent = Intent(this, AglaonemaPlant::class.java)
                    intent.putExtra("plants", clickedPlant)
                    startActivity(intent)
                }

                "Cast Iron Plant" -> {
                    val intent = Intent(this, CastironPlant::class.java)
                    intent.putExtra("plants", clickedPlant)
                    startActivity(intent)
                }

                "Swiss Cheese Plant" -> {
                    val intent = Intent(this, SwisscheesePlant::class.java)
                    intent.putExtra("plants", clickedPlant)
                    startActivity(intent)
                }

                "Air Plant" -> {
                    val intent = Intent(this, TillandsiaPlant::class.java)
                    intent.putExtra("plants", clickedPlant)
                    startActivity(intent)
                }

                "Sword Fern" -> {
                    val intent = Intent(this, SwordfernPlant::class.java)
                    intent.putExtra("plants", clickedPlant)
                    startActivity(intent)
                }

                "Calatheas Plant" -> {
                    val intent = Intent(this, CalatheasPlant::class.java)
                    intent.putExtra("plants", clickedPlant)
                    startActivity(intent)
                }

                "Dracaena Plant" -> {
                    val intent = Intent(this, DracaenaPlant::class.java)
                    intent.putExtra("plants", clickedPlant)
                    startActivity(intent)
                }

                "Begonia Plant" -> {
                    val intent = Intent(this, BegoniaPlant::class.java)
                    intent.putExtra("plants", clickedPlant)
                    startActivity(intent)
                }

                "Zebra Plant" -> {
                    val intent = Intent(this, ZebraPlant::class.java)
                    intent.putExtra("plants", clickedPlant)
                    startActivity(intent)
                }

                "Arboricola Plant" -> {
                    val intent = Intent(this, ArboricolaPlant::class.java)
                    intent.putExtra("plants", clickedPlant)
                    startActivity(intent)
                }

                "Norfolk Pine" -> {
                    val intent = Intent(this, NorfolkPine::class.java)
                    intent.putExtra("plants", clickedPlant)
                    startActivity(intent)
                }

                "Dragon Tree" -> {
                    val intent = Intent(this, DragonTree::class.java)
                    intent.putExtra("plants", clickedPlant)
                    startActivity(intent)
                }

                "InchPlant" -> {
                    val intent = Intent(this, InchPlant::class.java)
                    intent.putExtra("plants", clickedPlant)
                    startActivity(intent)
                }

                "Impatiens Plant" -> {
                    val intent = Intent(this, ImpatiensPlant::class.java)
                    intent.putExtra("plants", clickedPlant)
                    startActivity(intent)
                }

                "Sweet Alyssum" -> {
                    val intent = Intent(this, Sweetalyssum::class.java)
                    intent.putExtra("plants", clickedPlant)
                    startActivity(intent)
                }

                "Caladium Plant" -> {
                    val intent = Intent(this, CaladiumPlant::class.java)
                    intent.putExtra("plants", clickedPlant)
                    startActivity(intent)
                }

                "Lobelia Plant" -> {
                    val intent = Intent(this, LobeliaPlant::class.java)
                    intent.putExtra("plants", clickedPlant)
                    startActivity(intent)
                }

                "Torenia Plant" -> {
                    val intent = Intent(this, ToreniaPlant::class.java)
                    intent.putExtra("plants", clickedPlant)
                    startActivity(intent)
                }

                "Mandevilla Plant" -> {
                    val intent = Intent(this, MandevillaPlant::class.java)
                    intent.putExtra("plants", clickedPlant)
                    startActivity(intent)
                }

                "Hydrangea Plant" -> {
                    val intent = Intent(this, HydrangeaPlant::class.java)
                    intent.putExtra("plants", clickedPlant)
                    startActivity(intent)
                }

                "Heuchera Plant" -> {
                    val intent = Intent(this, HeucheraPlant::class.java)
                    intent.putExtra("plants", clickedPlant)
                    startActivity(intent)
                }

                "Violas Plant" -> {
                    val intent = Intent(this, ViolasPlant::class.java)
                    intent.putExtra("plants", clickedPlant)
                    startActivity(intent)
                }
            }
        }
    }

    private fun filterList(newText: String?) {
        val filteredList = ArrayList<Plants>()

        if (!newText.isNullOrBlank()) {
            for (plant in plantsList) {
                if (plant.name.lowercase(Locale.getDefault()).contains(newText.lowercase(Locale.getDefault()))) {
                    filteredList.add(plant)
                }
            }
        }
        else {
            // If the search text is empty, show the entire list
            filteredList.addAll(plantsList)
        }
        if (!initialSearchAttempted) {
            // If it's the first search attempt, display the original list
            initialSearchAttempted = true
        }

        if (filteredList.isEmpty()) {
            showNoPlantFoundToast()
        } else {
            hideNoPlantFoundToast()
        }

        plantsAdapter.setFilteredList(filteredList)

    }

    private fun showNoPlantFoundToast() {
        if (noPlantFoundToast == null) {
            noPlantFoundToast = Toast.makeText(this, "No Plant Found", Toast.LENGTH_SHORT)
            noPlantFoundToast?.show()
        }
    }

    private fun hideNoPlantFoundToast() {
        noPlantFoundToast?.cancel()
        noPlantFoundToast = null
    }
}
