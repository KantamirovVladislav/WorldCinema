package com.example.worldcinema

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.HORIZONTAL
import androidx.recyclerview.widget.RecyclerView.Orientation
import com.example.worldcinema.remote.Movie
import com.example.worldcinema.remote.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

        private val apiKey = "T2TXQGQ-DBH49R4-KE9QNDM-P5RE17J"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_films_list)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var dataSet = mutableListOf<BannerInfo>()
        dataSet.add(BannerInfo(R.drawable.preview2))
        dataSet.add(BannerInfo(R.drawable.preview3))
        dataSet.add(BannerInfo(R.drawable.preview4))
        dataSet.add(BannerInfo(R.drawable.preview5))

        var watchedSet = mutableListOf<BannerInfo>()
        watchedSet.add(BannerInfo(R.drawable.watchedfilm))
        watchedSet.add(BannerInfo(R.drawable.watchedfilm2))

        val recyclerFilms: RecyclerView = RecyclerView(this)
        recyclerFilms.adapter = BannerAdapter(dataSet)
        recyclerFilms.layoutManager = LinearLayoutManager(this).apply { this.orientation = HORIZONTAL }

        var dataSetActivity = mutableListOf<UserActivityContent>()
        dataSetActivity.add(
            UserActivityContent("В тренде", dataSet)
        )
        dataSetActivity.add(
            UserActivityContent("Вы смотрели", watchedSet)
        )
        dataSetActivity.add(
            UserActivityContent("Новое", dataSet)
        )
        dataSetActivity.add(
            UserActivityContent("Для вас", dataSet)
        )
        val recyclerView: RecyclerView = findViewById(R.id.recyclerViewForUserActivity)
        recyclerView.adapter = UserActivityAdapter(dataSetActivity)
        recyclerView.layoutManager = LinearLayoutManager(this)

        getRandomMovie()
    }

    private fun getRandomMovie() {
        val call = RetrofitClient.api.getRandomMovie(apiKey)

        call.enqueue(object : Callback<Movie> {
            override fun onResponse(call: Call<Movie>, response: Response<Movie>) {
                if (response.isSuccessful) {
                    val movie = response.body()
                    movie?.let {
                        // Обработка данных
                        Log.d("MovieData", it.toString())
                    }
                } else {
                    Log.e("APIError", "Response code: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<Movie>, t: Throwable) {
                Log.e("APIError", "Request failed: ${t.message}")
            }
        })
    }
}