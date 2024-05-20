package com.awilab.data.remote.schema

import com.awilab.common.extension.orZero
import com.awilab.domain.model.movie.Movie
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MovieSchema(
    @SerialName("adult")
    val isAdult: Boolean? = false,
    @SerialName("backdrop_path")
    val backdropPath: String? = "",
    @SerialName("genre_ids")
    val genreIds: List<Int?>? = listOf(),
    @SerialName("id")
    val id: Int? = 0,
    @SerialName("original_language")
    val originalLanguage: String? = "",
    @SerialName("original_title")
    val originalTitle: String? = "",
    @SerialName("overview")
    val overview: String? = "",
    @SerialName("popularity")
    val popularity: Double? = 0.0,
    @SerialName("poster_path")
    val posterPath: String? = "",
    @SerialName("release_date")
    val releaseDate: String? = "",
    @SerialName("title")
    val title: String? = "",
    @SerialName("video")
    val isVideo: Boolean? = false,
    @SerialName("vote_average")
    val voteAverage: Double? = 0.0,
    @SerialName("vote_count")
    val voteCount: Int? = 0,
)

internal fun List<MovieSchema>.toDomain(): List<Movie> = map(MovieSchema::toDomain)

internal fun MovieSchema.toDomain(): Movie = Movie(
    isAdult = isAdult ?: false,
    backdropPath = backdropPath.orEmpty(),
    genreIds = genreIds.orEmpty(),
    id = id.orZero(),
    originalLanguage = originalLanguage.orEmpty(),
    originalTitle = originalTitle.orEmpty(),
    overview = overview.orEmpty(),
    popularity = popularity.orZero(),
    posterPath = posterPath.orEmpty(),
    releaseDate = releaseDate.orEmpty(),
    title = title.orEmpty(),
    isVideo = isVideo ?: false,
    voteAverage = voteAverage.orZero(),
    voteCount = voteCount.orZero(),
)
