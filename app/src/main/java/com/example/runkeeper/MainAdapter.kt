package com.example.runkeeper

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainAdapter(private var applicationContext: Context, sectionList: ArrayList<Section>) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    private var AchItem: ArrayList<AchItem>? = null
    private var myAdapters: BadgeAdapter? = null
    private var gridLayoutManager: GridLayoutManager? = null

    var sectionList: ArrayList<Section> = ArrayList()
    init {
        this.sectionList=sectionList
    }

    class ViewHolder(@NonNull itemView:View):RecyclerView.ViewHolder(itemView) {
        var sectionName:TextView = itemView.findViewById(R.id.sectionName)
        var subTitle:TextView = itemView.findViewById(R.id.subTitle)
        var childRecyclerView:RecyclerView = itemView.findViewById(R.id.childRecyclerView)
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var layoutinflater:LayoutInflater= LayoutInflater.from(parent.context)
        var view:View=layoutinflater.inflate(R.layout.section_row, parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return sectionList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        var section: Section= sectionList.get(position)
        var sectionName: String= section.sectionName
        var subTitle: String? = section.sectionCount
        var items: ArrayList<AchItem> = section.sectionItems

        gridLayoutManager =
            GridLayoutManager(applicationContext, 2, LinearLayoutManager.VERTICAL, false)
        holder.childRecyclerView.layoutManager = gridLayoutManager
        holder.childRecyclerView.setHasFixedSize(true)

        AchItem = ArrayList()
        AchItem =items
        myAdapters = BadgeAdapter(applicationContext, AchItem!!)
        holder.childRecyclerView.adapter= myAdapters

        holder.sectionName.setText(sectionName)
        holder.subTitle.setText(subTitle)

    }



}