package com.example.worldcinema

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.worldcinema.FilmInfoAdapter.ViewHolder

class DescriptionAdapter(val dataSet: FilmInfo): RecyclerView.Adapter<DescriptionAdapter.ViewHolder>() {

    open class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val description: TextView = view.findViewById(R.id.textViewForDescriptionFilm)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.filmdescription, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = 0

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.description.text = dataSet.description
    }

}