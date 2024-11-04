package com.example.worldcinema

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.HORIZONTAL
import com.example.worldcinema.model.Data

class FilmsListActivity : AppCompatActivity() {
    private lateinit var button: Button
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: UserActivityAdapter
    private var dataSetActivity = mutableListOf<UserActivityContent>()


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

        initializeData()
        setupRecyclerView()

        val searchView = findViewById<SearchView>(R.id.searchView)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                filter(query)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filter(newText)
                return true
            }
        })
    }
    private fun initializeData() {
        dataSetActivity.add(UserActivityContent("В тренде", Data.dataSetBanner1))
        dataSetActivity.add(UserActivityContent("Вы смотрели", Data.dataSetBannerWatched))
        dataSetActivity.add(UserActivityContent("Новое", Data.dataSetBanner3))
        dataSetActivity.add(UserActivityContent("Для вас", Data.dataSetBanner2))
    }

    private fun setupRecyclerView() {
        recyclerView = findViewById(R.id.recyclerViewForUserActivity)
        adapter = UserActivityAdapter(dataSetActivity)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    private fun filter(query: String?) {
        val filteredData = dataSetActivity.map { category ->
            UserActivityContent(
                category.nameActivity,
                category.content.filter { it.title.contains(query ?: "", ignoreCase = true) }
            )
        }.filter { it.content.isNotEmpty() }

        adapter.updateData(filteredData)
    }

}