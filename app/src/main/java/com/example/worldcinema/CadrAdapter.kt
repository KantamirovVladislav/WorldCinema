package com.example.worldcinema

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.worldcinema.model.Episode
import com.example.worldcinema.model.FilmBanner
import com.example.worldcinema.model.FilmInfo

class CadrAdapter(val listBanner: List<Episode>) :
    RecyclerView.Adapter<CadrAdapter.ViewHolder>() {
    open class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imagePath: ImageView = view.findViewById(R.id.imageViewForBanner)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.filmbanner, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = listBanner.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.imagePath.setImageResource(listBanner[position].preview)
    }
}