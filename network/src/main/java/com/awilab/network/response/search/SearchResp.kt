package com.awilab.network.response.search

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SearchResp(
    val page: Int? = 0,
    val results: List<Result?>? = listOf(),
    @SerialName("total_pages")
    val totalPages: Int? = 0,
    @SerialName("total_results")
    val totalResults: Int? = 0,
) {
    @Serializable
    data class Result(
        val adult: Boolean? = false,
        @SerialName("backdrop_path")
        val backdropPath: String? = "",
        @SerialName("genre_ids")
        val genreIds: List<Int?>? = listOf(),
        val id: Int? = 0,
        @SerialName("original_language")
        val originalLanguage: String? = "",
        @SerialName("original_title")
        val originalTitle: String? = "",
        val overview: String? = "",
        val popularity: Double? = 0.0,
        @SerialName("poster_path")
        val posterPath: String? = "",
        @SerialName("release_date")
        val releaseDate: String? = "",
        val title: String? = "",
        val video: Boolean? = false,
        @SerialName("vote_average")
        val voteAverage: Double? = 0.0,
        @SerialName("vote_count")
        val voteCount: Int? = 0,
    )
}
