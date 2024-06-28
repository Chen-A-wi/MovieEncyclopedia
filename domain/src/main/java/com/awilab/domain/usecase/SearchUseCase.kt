package com.awilab.domain.usecase

import com.awilab.domain.common.UseCase
import com.awilab.domain.model.PaginatedData
import com.awilab.domain.model.movie.Movie
import com.awilab.domain.repository.SearchRepository
import kotlinx.coroutines.flow.Flow

class SearchUseCase(
    private val searchRepository: SearchRepository,
) : UseCase<PaginatedData<Movie>> {
    override fun invoke(): Flow<Result<PaginatedData<Movie>>> {
        TODO("Not yet implemented")
    }
}
