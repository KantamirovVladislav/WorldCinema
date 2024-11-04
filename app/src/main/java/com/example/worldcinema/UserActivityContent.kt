package com.example.worldcinema

import com.example.worldcinema.model.FilmBanner
import com.example.worldcinema.model.FilmInfo

data class UserActivityContent(
    val nameActivity: String,
    val content: List<FilmInfo>
)