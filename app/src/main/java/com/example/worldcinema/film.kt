package com.example.worldcinema

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.HORIZONTAL
import com.example.worldcinema.model.Data
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexWrap
import com.google.android.flexbox.FlexboxLayoutManager

class film : AppCompatActivity() {
    lateinit var button: ImageButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_film)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        button = findViewById(R.id.backImageButton)
        button.setOnClickListener{
            finish()
        }

        var dataSetActivity = mutableListOf<UserActivityContent>()
//        dataSetActivity.add(
//            UserActivityContent("Жанры", Data.data)
//        )
        dataSetActivity.add(
            UserActivityContent("Смотреть", Data.dataSetBannerWatchedNext)
        )
        dataSetActivity.add(
            UserActivityContent("Описание", Data.dataSetFilmInfo)
        )
        dataSetActivity.add(
            UserActivityContent("Кадры", Data.dataSetFilmInfo)
        )
        dataSetActivity.add(
            UserActivityContent("Эпизоды", Data.dataSetFilmInfo)
        )
        val recyclerGenres: RecyclerView = findViewById(R.id.recyclerViewForGenres)
        recyclerGenres.adapter = GenresAdapter(Data.dataSetFilmInfo[0].genres)
        recyclerGenres.layoutManager = FlexboxLayoutManager(this).apply {
            flexDirection = FlexDirection.ROW
            flexWrap = FlexWrap.WRAP
        }
        val recyclerView: RecyclerView = findViewById(R.id.recyclerViewForUserActivity)
        recyclerView.adapter = FilmInfoAdapter(dataSetActivity)
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

}