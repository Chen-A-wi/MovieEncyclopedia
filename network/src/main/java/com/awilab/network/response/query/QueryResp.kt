package com.awilab.network.response.query

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class QueryResp(
    @SerialName("adult")
    val adult: Boolean? = false,
    @SerialName("backdrop_path")
    val backdropPath: String? = "",
    @SerialName("created_by")
    val creatorList: List<Creator?>? = listOf(),
    @SerialName("episode_run_time")
    val episodeRunTime: List<Int?>? = listOf(),
    @SerialName("first_air_date")
    val firstAirDate: String? = "",
    @SerialName("genres")
    val genres: List<Genre?>? = listOf(),
    @SerialName("homepage")
    val homepage: String? = "",
    @SerialName("id")
    val id: Int? = 0,
    @SerialName("in_production")
    val inProduction: Boolean? = false,
    @SerialName("languages")
    val languages: List<String?>? = listOf(),
    @SerialName("last_air_date")
    val lastAirDate: String? = "",
    @SerialName("last_episode_to_air")
    val lastEpisodeToAir: LastEpisodeToAir? = LastEpisodeToAir(),
    @SerialName("name")
    val name: String? = "",
    @SerialName("networks")
    val networks: List<Network?>? = listOf(),
    @SerialName("next_episode_to_air")
    val nextEpisodeToAir: NextEpisodeToAir? = NextEpisodeToAir(),
    @SerialName("number_of_episodes")
    val numberOfEpisodes: Int? = 0,
    @SerialName("number_of_seasons")
    val numberOfSeasons: Int? = 0,
    @SerialName("origin_country")
    val originCountry: List<String?>? = listOf(),
    @SerialName("original_language")
    val originalLanguage: String? = "",
    @SerialName("original_name")
    val originalName: String? = "",
    @SerialName("overview")
    val overview: String? = "",
    @SerialName("popularity")
    val popularity: Double? = 0.0,
    @SerialName("poster_path")
    val posterPath: String? = "",
    @SerialName("production_companies")
    val productionCompanies: List<ProductionCompany?>? = listOf(),
    @SerialName("production_countries")
    val productionCountries: List<ProductionCountry?>? = listOf(),
    @SerialName("seasons")
    val seasons: List<Season?>? = listOf(),
    @SerialName("spoken_languages")
    val spokenLanguages: List<SpokenLanguage?>? = listOf(),
    @SerialName("status")
    val status: String? = "",
    @SerialName("tagline")
    val tagline: String? = "",
    @SerialName("type")
    val type: String? = "",
    @SerialName("vote_average")
    val voteAverage: Double? = 0.0,
    @SerialName("vote_count")
    val voteCount: Int? = 0,
) {
    @Serializable
    data class Genre(
        @SerialName("id")
        val id: Int? = 0,
        @SerialName("name")
        val name: String? = "",
    )

    @Serializable
    data class LastEpisodeToAir(
        @SerialName("air_date")
        val airDate: String? = "",
        @SerialName("episode_number")
        val episodeNumber: Int? = 0,
        @SerialName("episode_type")
        val episodeType: String? = "",
        @SerialName("id")
        val id: Int? = 0,
        @SerialName("name")
        val name: String? = "",
        @SerialName("overview")
        val overview: String? = "",
        @SerialName("production_code")
        val productionCode: String? = "",
        @SerialName("runtime")
        val runtime: Int? = 0,
        @SerialName("season_number")
        val seasonNumber: Int? = 0,
        @SerialName("show_id")
        val showId: Int? = 0,
        @SerialName("still_path")
        val stillPath: String? = "",
        @SerialName("vote_average")
        val voteAverage: Double? = 0.0,
        @SerialName("vote_count")
        val voteCount: Int? = 0,
    )

    @Serializable
    data class Network(
        @SerialName("id")
        val id: Int? = 0,
        @SerialName("logo_path")
        val logoPath: String? = "",
        @SerialName("name")
        val name: String? = "",
        @SerialName("origin_country")
        val originCountry: String? = "",
    )

    @Serializable
    data class NextEpisodeToAir(
        @SerialName("air_date")
        val airDate: String? = "",
        @SerialName("episode_number")
        val episodeNumber: Int? = 0,
        @SerialName("episode_type")
        val episodeType: String? = "",
        @SerialName("id")
        val id: Int? = 0,
        @SerialName("name")
        val name: String? = "",
        @SerialName("overview")
        val overview: String? = "",
        @SerialName("production_code")
        val productionCode: String? = "",
        @SerialName("runtime")
        val runtime: Int? = 0,
        @SerialName("season_number")
        val seasonNumber: Int? = 0,
        @SerialName("show_id")
        val showId: Int? = 0,
        @SerialName("still_path")
        val stillPath: String? = "",
        @SerialName("vote_average")
        val voteAverage: Double? = 0.0,
        @SerialName("vote_count")
        val voteCount: Int? = 0,
    )

    @Serializable
    data class ProductionCompany(
        @SerialName("id")
        val id: Int? = 0,
        @SerialName("logo_path")
        val logoPath: String? = "",
        @SerialName("name")
        val name: String? = "",
        @SerialName("origin_country")
        val originCountry: String? = "",
    )

    @Serializable
    data class ProductionCountry(
        @SerialName("iso_3166_1")
        val iso31661: String? = "",
        @SerialName("name")
        val name: String? = "",
    )

    @Serializable
    data class Season(
        @SerialName("air_date")
        val airDate: String? = "",
        @SerialName("episode_count")
        val episodeCount: Int? = 0,
        @SerialName("id")
        val id: Int? = 0,
        @SerialName("name")
        val name: String? = "",
        @SerialName("overview")
        val overview: String? = "",
        @SerialName("poster_path")
        val posterPath: String? = "",
        @SerialName("season_number")
        val seasonNumber: Int? = 0,
        @SerialName("vote_average")
        val voteAverage: Double? = 0.0,
    )

    @Serializable
    data class SpokenLanguage(
        @SerialName("english_name")
        val englishName: String? = "",
        @SerialName("iso_639_1")
        val iso6391: String? = "",
        @SerialName("name")
        val name: String? = "",
    )

    @Serializable
    data class Creator(
        @SerialName("credit_id")
        val creditId: String? = "",
        @SerialName("gender")
        val gender: Int? = 0,
        @SerialName("id")
        val id: Int? = 0,
        @SerialName("name")
        val name: String? = "",
        @SerialName("profile_path")
        val profilePath: String? = "",
    )
}
