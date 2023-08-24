package com.example.sowandgrow

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sowandgrow.plantdetails.AglaonemaPlant
import com.example.sowandgrow.plantdetails.AloeveraPlant
import com.example.sowandgrow.plantdetails.ArecaPlant
import com.example.sowandgrow.plantdetails.ArrowheadVine
import com.example.sowandgrow.plantdetails.AshwagandhaPlant
import com.example.sowandgrow.plantdetails.BegoniaPlant
import com.example.sowandgrow.plantdetails.BetelPlant
import com.example.sowandgrow.plantdetails.BonsaiPlant
import com.example.sowandgrow.plantdetails.BostonFern
import com.example.sowandgrow.plantdetails.BougainvilleaPlant
import com.example.sowandgrow.plantdetails.CactusPlant
import com.example.sowandgrow.plantdetails.CaladiumPlant
import com.example.sowandgrow.plantdetails.CalatheasPlant
import com.example.sowandgrow.plantdetails.CastironPlant
import com.example.sowandgrow.plantdetails.CrotonPLant
import com.example.sowandgrow.plantdetails.DevilivyPlant
import com.example.sowandgrow.plantdetails.DracaenaPlant
import com.example.sowandgrow.plantdetails.DragonTree
import com.example.sowandgrow.plantdetails.Englishivy
import com.example.sowandgrow.plantdetails.FiddleleafigPlant
import com.example.sowandgrow.plantdetails.HeucheraPlant
import com.example.sowandgrow.plantdetails.HibiscusPlant
import com.example.sowandgrow.plantdetails.HolyBasil
import com.example.sowandgrow.plantdetails.HydrangeaPlant
import com.example.sowandgrow.plantdetails.ImpatiensPlant
import com.example.sowandgrow.plantdetails.InchPlant
import com.example.sowandgrow.plantdetails.JadePlant
import com.example.sowandgrow.plantdetails.JasminePlant
import com.example.sowandgrow.plantdetails.LaceleafPlant
import com.example.sowandgrow.plantdetails.LavenderPlant
import com.example.sowandgrow.plantdetails.Lemongrass
import com.example.sowandgrow.plantdetails.LobeliaPlant
import com.example.sowandgrow.plantdetails.LuckyBamboo
import com.example.sowandgrow.plantdetails.MandevillaPlant
import com.example.sowandgrow.plantdetails.MarigoldPlant
import com.example.sowandgrow.plantdetails.Mint
import com.example.sowandgrow.plantdetails.MoneyPlant
import com.example.sowandgrow.plantdetails.Neem
import com.example.sowandgrow.plantdetails.NorfolkPine
import com.example.sowandgrow.plantdetails.PeacelilyPlant
import com.example.sowandgrow.plantdetails.PhilodendronPlant
import com.example.sowandgrow.plantdetails.PothosPlant
import com.example.sowandgrow.plantdetails.RosePlant
import com.example.sowandgrow.plantdetails.RoseusPlant
import com.example.sowandgrow.plantdetails.RubberPlant
import com.example.sowandgrow.plantdetails.SnakePlant
import com.example.sowandgrow.plantdetails.SpiderPlant
import com.example.sowandgrow.plantdetails.Sweetalyssum
import com.example.sowandgrow.plantdetails.SwisscheesePlant
import com.example.sowandgrow.plantdetails.SwordfernPlant
import com.example.sowandgrow.plantdetails.TillandsiaPlant
import com.example.sowandgrow.plantdetails.ToreniaPlant
import com.example.sowandgrow.plantdetails.VerbenaPlant
import com.example.sowandgrow.plantdetails.ViolasPlant
import com.example.sowandgrow.plantdetails.WeepingfigPlant
import com.example.sowandgrow.plantdetails.ZebraPlant
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
        plantsList.add(Plants(R.drawable.caladiumplant, "Caladium Plant"))
        plantsList.add(Plants(R.drawable.cactus1, "Cactus Plant"))
        plantsList.add(Plants(R.drawable.calatheaplant, "Calatheas Plant"))
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
                    val intent = Intent(this, AglaonemaPlant::class.java)
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
}
