package com.example.worldcinema

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.worldcinema.remote.Movie
import com.example.worldcinema.remote.RetrofitClient
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Call

class FilmsListActivity : AppCompatActivity() {

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

        getRandomMovie()
    }

    private fun getRandomMovie() {
        val call = RetrofitClient.api.getRandomMovie()

        call.enqueue(object : Callback<Movie> {
            override fun onResponse(call: Call<Movie>, response: Response<Movie>) {
                if (response.isSuccessful) {
                    val movie = response.body()
                    movie?.let {
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