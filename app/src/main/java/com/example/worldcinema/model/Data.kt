package com.example.worldcinema.model

import com.example.worldcinema.R

object Data {
    var dataSetFilmInfo = mutableListOf<FilmInfo>(
        FilmInfo(
            "1+1",
            genres = listOf(
                "ужасы",
                "фэнтези",
                "приключения",
                "приключения",
                "приключения",
                "приключения"
            ),
            description = "Аристократ на коляске нанимает в сиделки бывшего заключенного. Искрометная французская комедия с Омаром Си",
            episodes = listOf(
                Episode(
                    title = "Эпизод 1",
                    description = "Пострадав в результате несчастного случая, богатый аристократ Филипп нанимает в помощники человека",
                    duration = "20:21",
                    preview = R.drawable.watchedfilm
                ),
                Episode(
                    title = "Эпизод 2",
                    description = "– молодого жителя предместья Дрисса, только что освободившегося из тюрьмы.",
                    duration = "21:20",
                    preview = R.drawable.watched4
                ),
                Episode(
                    title = "Эпизод 3",
                    description = "Несмотря на то, что Филипп прикован к инвалидному креслу",
                    duration = "21:20",
                    preview = R.drawable.watched5
                )
            ),
            imageSource = R.drawable.preview2
        )
    )

    var dataSetBanner1 = mutableListOf<FilmInfo>(
        FilmInfo(
            title = "1+1",
            imageSource = R.drawable.preview2,
            episodes = listOf(Episode(title = " ", description = " ", duration = " ", preview = 1)),
            genres = listOf(),
            description = "Описание"
        ),
        FilmInfo(
            title = "Малефисента",
            imageSource = R.drawable.preview3,
            episodes = listOf(Episode(title = " ", description = " ", duration = " ", preview = 1)),
            genres = listOf(),
            description = "Описание"
        ),
        FilmInfo(
            title = "Прометей",
            imageSource = R.drawable.preview4,
            episodes = listOf(Episode(title = " ", description = " ", duration = " ", preview = 1)),
            genres = listOf(),
            description = "Описание"
        ),
        FilmInfo(
            title = "Цитадель",
            imageSource = R.drawable.preview5,
            episodes = listOf(Episode(title = " ", description = " ", duration = " ", preview = 1)),
            genres = listOf(),
            description = "Описание"
        )
    )

    var dataSetBanner2 = mutableListOf<FilmInfo>(
        FilmInfo(
            title = "Джокер",
            imageSource = R.drawable.preview6,
            episodes = listOf(Episode(title = " ", description = " ", duration = " ", preview = 1)),
            genres = listOf(),
            description = "Описание"
        ),
        FilmInfo(
            title = "Игра престолов",
            imageSource = R.drawable.preview7,
            episodes = listOf(Episode(title = " ", description = " ", duration = " ", preview = 1)),
            genres = listOf(),
            description = "Описание"
        ),
        FilmInfo(
            title = "Бордерлендс",
            imageSource = R.drawable.preview8,
            episodes = listOf(Episode(title = " ", description = " ", duration = " ", preview = 1)),
            genres = listOf(),
            description = "Описание"
        ),
        FilmInfo(
            title = "Главный герой",
            imageSource = R.drawable.preview9,
            episodes = listOf(Episode(title = " ", description = " ", duration = " ", preview = 1)),
            genres = listOf(),
            description = "Описание"
        )
    )

    var dataSetBanner3 = mutableListOf<FilmInfo>(
        FilmInfo(
            title = "Однажды в голливуде",
            imageSource = R.drawable.preview10,
            episodes = listOf(Episode(title = " ", description = " ", duration = " ", preview = 1)),
            genres = listOf(),
            description = "Описание"
        ),
        FilmInfo(
            title = "Позывной пассажир",
            imageSource = R.drawable.preview11,
            episodes = listOf(Episode(title = " ", description = " ", duration = " ", preview = 1)),
            genres = listOf(),
            description = "Описание"
        )
    )

    var dataSetBannerWatched = mutableListOf<FilmInfo>(
        FilmInfo(
            title = "1+1",
            imageSource = R.drawable.watchedfilm,
            episodes = listOf(Episode(title = " ", description = " ", duration = " ", preview = 1)),
            genres = listOf(),
            description = "Описание"
        ),
        FilmInfo(
            title = "Живая сталь",
            imageSource = R.drawable.watchedfilm2,
            episodes = listOf(Episode(title = " ", description = " ", duration = " ", preview = 1)),
            genres = listOf(),
            description = "Описание"
        )
    )

    var dataSetBannerWatchedNext = mutableListOf(
        FilmInfo(
            "1+1",
            imageSource = R.drawable.watchedfilm,
            episodes = listOf(Episode(title = " ", description = " ", duration = " ", preview = 1)),
            genres = listOf(),
            description = "Описание"
        )
    )

}