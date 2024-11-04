package com.example.worldcinema

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.HORIZONTAL
import androidx.recyclerview.widget.RecyclerView.VERTICAL
import com.example.worldcinema.BannerAdapter.ViewHolder

class FilmInfoAdapter(val dataSet: List<UserActivityContent>) :
    RecyclerView.Adapter<FilmInfoAdapter.ViewHolder>() {

    open class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val text: TextView = view.findViewById(R.id.textViewForUserActivityName)
        val recycler: RecyclerView = view.findViewById(R.id.recyclerViewForUserActivityName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.mainuseractivitylist, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = dataSet.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.recycler.setHasFixedSize(true)
        holder.recycler.isNestedScrollingEnabled = false
        when(dataSet[position].nameActivity){
            "Смотреть" -> {
                holder.text.text = dataSet[position].nameActivity
                holder.text.setTextColor(Color.parseColor("#ffffff"))
                holder.recycler.adapter = BannerAdapter(dataSet[position].content)
                holder.recycler.layoutManager = LinearLayoutManager(holder.itemView.context).apply { this.orientation = HORIZONTAL }
            }
            "Описание" -> {
                holder.text.text = dataSet[position].nameActivity
                holder.text.setTextColor(Color.parseColor("#ffffff"))
                holder.recycler.adapter = DescriptionAdapter(dataSet[position].content[0])
                holder.recycler.layoutManager = LinearLayoutManager(holder.itemView.context)
            }
            "Кадры" -> {
                holder.text.text = dataSet[position].nameActivity
                holder.text.setTextColor(Color.parseColor("#ffffff"))
                holder.recycler.adapter = CadrAdapter(dataSet[position].content[0].episodes)
                holder.recycler.layoutManager = LinearLayoutManager(holder.itemView.context).apply { this.orientation = HORIZONTAL }
            }
            "Эпизоды" -> {
                holder.text.text = dataSet[position].nameActivity
                holder.text.setTextColor(Color.parseColor("#ffffff"))
                holder.recycler.adapter = EpisodesAdapter(dataSet[position].content[0].episodes)
                holder.recycler.layoutManager = LinearLayoutManager(holder.itemView.context).apply { this.orientation = VERTICAL }
            }
            else -> return
        }
    }
}