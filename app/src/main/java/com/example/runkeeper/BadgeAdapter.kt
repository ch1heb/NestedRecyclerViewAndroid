package com.example.runkeeper

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class BadgeAdapter(var context: Context, var arrayList: ArrayList<AchItem>) :
    RecyclerView.Adapter<BadgeAdapter.ItemHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val viewHolder = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_item, parent, false)
        return ItemHolder(viewHolder)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {

        val achItem: AchItem = arrayList.get(position)

        holder.icons?.setImageResource(achItem.icons!!)
        holder.titles?.text = achItem.Achtype
        holder.record?.text = achItem.record

        holder.itemView.setOnClickListener{
            Toast.makeText(context, achItem.Achtype, Toast.LENGTH_LONG).show()
        }
    }

    class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var icons: ImageView? = itemView.findViewById<ImageView>(R.id.imageView)
        var titles: TextView? = itemView.findViewById<TextView>(R.id.textView)
        var record: TextView? = itemView.findViewById<TextView>(R.id.record)
    }


}