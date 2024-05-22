package com.awilab.data.repository.search

import com.awilab.common.QueryType
import com.awilab.data.remote.api.TmdbSearchServices
import com.awilab.data.remote.schema.MoviePaginatedSchema
import com.awilab.data.remote.schema.toDomain
import com.awilab.domain.model.PaginatedData
import com.awilab.domain.model.movie.Movie
import com.awilab.domain.repository.SearchRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

class SearchRepositoryImpl(
    private val searchServices: TmdbSearchServices,
) : SearchRepository {
    override fun searchMovies(
        query: String,
        page: Int,
        language: String?,
    ): Flow<PaginatedData<Movie>> = flow {
        searchServices.searchTmdb(
            searchType = QueryType.MOVIE.name.lowercase(),
            query = query,
            page = page,
            language = language,
        ).also { response -> emit(response) }
    }.map(MoviePaginatedSchema::toDomain)
}
