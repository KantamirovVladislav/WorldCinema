package com.example.worldcinema

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.HORIZONTAL
import com.example.worldcinema.model.Data

class FilmsListActivity : AppCompatActivity() {
    lateinit var button: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_films_list)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        button = findViewById(R.id.buttonNextFilmInfo)
        button.setOnClickListener{
            Intent(this, film::class.java).apply {
                startActivity(this)
            }
        }

        var dataSetActivity = mutableListOf<UserActivityContent>()
        dataSetActivity.add(UserActivityContent("В тренде", Data.dataSetBanner1))
        dataSetActivity.add(UserActivityContent("Вы смотрели", Data.dataSetBannerWatched))
        dataSetActivity.add(UserActivityContent("Новое", Data.dataSetBanner3))
        dataSetActivity.add(UserActivityContent("Для вас", Data.dataSetBanner2))

        val recyclerView: RecyclerView = findViewById(R.id.recyclerViewForUserActivity)
        recyclerView.adapter = UserActivityAdapter(dataSetActivity)
        recyclerView.layoutManager = LinearLayoutManager(this)

    }

}