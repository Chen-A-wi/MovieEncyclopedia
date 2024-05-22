package com.awilab.domain.repository

import com.awilab.domain.model.PaginatedData
import com.awilab.domain.model.movie.Movie
import kotlinx.coroutines.flow.Flow

interface SearchRepository {
    fun searchMovies(
        query: String,
        page: Int,
        language: String?,
    ): Flow<PaginatedData<Movie>>
}
