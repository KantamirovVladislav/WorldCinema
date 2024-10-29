package com.example.worldcinema

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.HORIZONTAL

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_film)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var dataSet = mutableListOf<FilmInfo>()
        dataSet.add(FilmInfo(
            "Test1",
            genres = listOf("genre1","genre2"),
            description = "Description1",
            episodes = listOf(
                Episode(
                    title = "TestTitle1",
                    description = "TestDescription2",
                    duration = "20:21",
                    preview = R.drawable.watchedfilm
                ),
                Episode(
                    title = "TestTitle1",
                    description = "TestDescription2",
                    duration = "21:20",
                    preview = R.drawable.watchedfilm2
                )
            ),
            imageSource = R.drawable.preview2
        ))

//
//        var watchedSet = mutableListOf<FilmInfo>()
//        watchedSet.add(FilmInfo(R.drawable.watchedfilm))
//        watchedSet.add(FilmInfo(R.drawable.watchedfilm2))


        var dataSetActivity = mutableListOf<UserActivityContent>()
        dataSetActivity.add(
            UserActivityContent("Смотреть", dataSet)
        )
        dataSetActivity.add(
            UserActivityContent("Описание", dataSet)
        )
        dataSetActivity.add(
            UserActivityContent("Кадры", dataSet)
        )
        dataSetActivity.add(
            UserActivityContent("Эпизоды", dataSet)
        )
        val recyclerView: RecyclerView = findViewById(R.id.recyclerViewForUserActivity)
        recyclerView.adapter = FilmInfoAdapter(dataSetActivity)
        recyclerView.layoutManager = LinearLayoutManager(this)

    }
}