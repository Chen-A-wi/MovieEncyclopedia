package com.awilab.data.remote.schema

import com.awilab.common.extension.orZero
import com.awilab.domain.model.PaginatedData
import com.awilab.domain.model.movie.Movie
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MoviePaginatedSchema(
    @SerialName("page")
    val page: Int? = 0,
    @SerialName("results")
    val results: List<MovieSchema>? = listOf(),
    @SerialName("total_pages")
    val totalPages: Int? = 0,
    @SerialName("total_results")
    val totalResults: Int? = 0,
)

internal fun MoviePaginatedSchema.toDomain(): PaginatedData<Movie> = PaginatedData(
    page = page.orZero(),
    results = results?.toDomain() ?: emptyList(),
    totalPages = totalPages.orZero(),
    totalResults = totalResults.orZero(),
)
