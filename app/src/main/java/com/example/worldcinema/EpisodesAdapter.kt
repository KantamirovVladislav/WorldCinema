package com.example.worldcinema

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.worldcinema.FilmInfoAdapter.ViewHolder
import org.w3c.dom.Text

class EpisodesAdapter(val dataSet: List<Episode>): RecyclerView.Adapter<EpisodesAdapter.ViewHolder>() {

    open class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val imageSource: ImageView = view.findViewById(R.id.imageViewForEpisode)
        val title: TextView = view.findViewById(R.id.textViewForTitleEpisode)
        val description: TextView = view.findViewById(R.id.textViewForDescriptionEpisode)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.episode, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = dataSet.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.imageSource.setImageResource(dataSet[position].preview)
        holder.title.text = dataSet[position].title
        holder.description.text = dataSet[position].description
    }

}