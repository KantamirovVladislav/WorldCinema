package com.example.worldcinema.model

data class FilmInfo(
    val title: String,
    val genres: List<String>,
    val description: String,
    val episodes: List<Episode>,
    val imageSource: Int
)
