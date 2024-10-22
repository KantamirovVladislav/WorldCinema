package com.example.worldcinema

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.HORIZONTAL
import com.example.worldcinema.BannerAdapter.ViewHolder

class UserActivityAdapter(val dataSet: List<UserActivityContent>): RecyclerView.Adapter<UserActivityAdapter.ViewHolder>() {
    open class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val text: TextView = view.findViewById(R.id.textViewForUserActivityName)
        var recyclerView: RecyclerView = view.findViewById(R.id.recyclerViewForUserActivityName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.mainuseractivitylist, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = dataSet.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.text.text = dataSet[position].nameActivity
        holder.recyclerView.adapter = BannerAdapter(dataSet[position].content)
        holder.recyclerView.layoutManager = LinearLayoutManager(holder.itemView.context).apply { this.orientation = HORIZONTAL }
    }


}