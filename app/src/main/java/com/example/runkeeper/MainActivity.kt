package com.example.runkeeper

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {

    private var recyclerView: RecyclerView? = null
    private var linearLayoutManager: LinearLayoutManager? = null

    private var myAdapters: MainAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Toolbar setting overriding the default toolbar
        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_back)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayShowCustomEnabled(true)

        //Main RecyclerView to hold the child RecyclerView
        recyclerView = findViewById(R.id.recycler_view_item)
        linearLayoutManager =
            LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
        recyclerView?.layoutManager = linearLayoutManager
        recyclerView?.setHasFixedSize(true)

        initData()
        myAdapters = MainAdapter(applicationContext, sectionList!!) //Passing the data to be displayed in the main and child RecyclerView
        recyclerView?.adapter = myAdapters

    }

    private fun reload() {
        Toast.makeText(
            applicationContext, "Reload",
            Toast.LENGTH_SHORT
        ).show()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.nav_menu, menu)
        return true
    }
    //Menu Selection Action
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.nav_option -> reload()
        }
        return super.onOptionsItemSelected(item)
    }

    var sectionList: ArrayList<Section> = ArrayList()

    //Mock data to be populated from DB in prod
    private fun initData(): ArrayList<Section>{

        var sectionOneName="Personal Records"
        var sectionOneCount: String?="4 of 6"
        var sectionOne: ArrayList<AchItem> = ArrayList()
        sectionOne.add(AchItem(R.drawable.longest_run, "Longest Run","00:00"))
        sectionOne.add(AchItem(R.drawable.highest_elevation, "Highest Elevation", "2095 ft"))
        sectionOne.add(AchItem(R.drawable.fastest_5k, "Fastest 5K", "00:00"))
        sectionOne.add(AchItem(R.drawable.a10k, "10K", "00:00:00"))
        sectionOne.add(AchItem(R.drawable.half_marathon, "Half Marathon", "00:00"))
        sectionOne.add(AchItem(R.drawable.marathon, "Marathon", "Not Yet"))


        var sectionTwoName="Virtual Races"
        var sectionTwoCount: String?=null
        var sectionTwo: ArrayList<AchItem> = ArrayList()
        sectionTwo.add(AchItem(R.drawable.v_half, "Virtual Half Marathon Race", "00:00"))
        sectionTwo.add(AchItem(R.drawable.tokyo_h, "Tokyo-Hakone Ekiden 2020", "00:00:00"))
        sectionTwo.add(AchItem(R.drawable.v_10k, "Virtual 10K Race", "00:00:00"))
        sectionTwo.add(AchItem(R.drawable.hakone_ekiden, "Hakone Ekiden", "00:00:00"))
        sectionTwo.add(AchItem(R.drawable.mizuno_singapore, "Mizuno Singapore Ekiden 2015", "00:00:00"))
        sectionTwo.add(AchItem(R.drawable.v5k, "Virtual 5K Race", "23:07"))

        sectionList.add(Section(sectionOneName, sectionOneCount, sectionOne))
        sectionList.add(Section(sectionTwoName, sectionTwoCount, sectionTwo))


        return sectionList
    }



}