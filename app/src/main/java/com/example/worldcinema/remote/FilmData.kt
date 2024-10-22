package com.example.worldcinema.remote

//data class FilmData()
class Movie(
    val id: Int,
    val externalId: ExternalId,
    val name: String,
    val alternativeName: String?,
    val enName: String?,
    val names: List<Name>,
    val type: String,
    val typeNumber: Int,
    val year: Int,
    val description: String?,
    val shortDescription: String?,
    val slogan: String?,
    val status: String,
    val facts: List<Fact>,
    val rating: Rating,
    val votes: Votes,
    val movieLength: Int,
    val ratingMpaa: String?,
    val ageRating: Int?,
    val logo: Image?,
    val poster: Poster?,
    val backdrop: Poster?,
    val videos: Videos?,
    val genres: List<Genre>,
    val countries: List<Country>,
    val persons: List<Person>,
    val reviewInfo: ReviewInfo?,
    val seasonsInfo: List<SeasonInfo>?,
    val budget: Budget?,
    val fees: Fees?,
    val premiere: Premiere?,
    val similarMovies: List<RelatedMovie>?,
    val sequelsAndPrequels: List<RelatedMovie>?,
    val watchability: Watchability?,
    val releaseYears: List<ReleaseYear>?,
    val top10: Int?,
    val top250: Int?,
    val ticketsOnSale: Boolean?,
    val totalSeriesLength: Int?,
    val seriesLength: Int?,
    val isSeries: Boolean,
    val audience: List<Audience>?,
    val lists: List<String>?,
    val networks: Networks?,
    val updatedAt: String,
    val createdAt: String
)

data class ExternalId(
    val kpHD: String?,
    val imdb: String?,
    val tmdb: Int?
)

data class Name(
    val name: String,
    val language: String?,
    val type: String?
)

data class Fact(
    val value: String,
    val type: String?,
    val spoiler: Boolean
)

data class Rating(
    val kp: Double,
    val imdb: Double,
    val tmdb: Double,
    val filmCritics: Double,
    val russianFilmCritics: Double,
    val await: Double
)

data class Votes(
    val kp: String,
    val imdb: Int,
    val tmdb: Int,
    val filmCritics: Int,
    val russianFilmCritics: Int,
    val await: Int
)

data class Image(
    val url: String
)

data class Poster(
    val url: String,
    val previewUrl: String
)

data class Videos(
    val trailers: List<Trailer>
)

data class Trailer(
    val url: String,
    val name: String,
    val site: String,
    val size: Int,
    val type: String
)

data class Genre(
    val name: String
)

data class Country(
    val name: String
)

data class Person(
    val id: Int,
    val photo: String?,
    val name: String,
    val enName: String?,
    val description: String?,
    val profession: String?,
    val enProfession: String?
)

data class ReviewInfo(
    val count: Int,
    val positiveCount: Int,
    val percentage: String?
)

data class SeasonInfo(
    val number: Int,
    val episodesCount: Int
)

data class Budget(
    val value: Int,
    val currency: String
)

data class Fees(
    val world: Fee?,
    val russia: Fee?,
    val usa: Fee?
)

data class Fee(
    val value: Int,
    val currency: String
)

data class Premiere(
    val country: String?,
    val world: String?,
    val russia: String?,
    val digital: String?,
    val cinema: String?,
    val bluray: String?,
    val dvd: String?
)

data class RelatedMovie(
    val id: Int,
    val name: String,
    val enName: String?,
    val alternativeName: String?,
    val type: String?,
    val poster: Poster?,
    val rating: Rating?,
    val year: Int?
)

data class Watchability(
    val items: List<WatchabilityItem>?
)

data class WatchabilityItem(
    val name: String,
    val logo: Image?,
    val url: String?
)

data class ReleaseYear(
    val start: Int,
    val end: Int?
)

data class Audience(
    val count: Int,
    val country: String
)

data class Networks(
    val items: List<NetworkItem>?
)

data class NetworkItem(
    val name: String,
    val logo: Image?
)