package com.example.worldcinema.remote

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import com.example.worldcinema.remote.Movie
object RetrofitClient {
    private const val BASE_URL = "https://api.kinopoisk.dev/"

    val api: KinopoiskApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(KinopoiskApiService::class.java)
    }
}

interface KinopoiskApiService {

    @GET("v1.4/movie/random")
    fun getRandomMovie(
        @Header("X-API-KEY") apiKey: String
    ): Call<Movie>
}