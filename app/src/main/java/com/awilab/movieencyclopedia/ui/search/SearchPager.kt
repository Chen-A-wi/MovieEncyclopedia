package com.awilab.movieencyclopedia.ui.search

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.awilab.domain.model.movie.Movie
import com.awilab.domain.repository.SearchRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flatMapLatest

@OptIn(FlowPreview::class, ExperimentalCoroutinesApi::class)
class SearchPager(
    config: PagingConfig = PagingConfig(pageSize = 20),
    private val searchRepository: SearchRepository,
) {
    val query = MutableStateFlow("")

    val pagingDataFlow: Flow<PagingData<Movie>> = query.debounce(500)
        .distinctUntilChanged()
        .flatMapLatest { query ->
            Pager(
                config = config,
                pagingSourceFactory = {
                    SearchPagingSource(
                        query = query,
                        searchRepository = searchRepository,
                    )
                },
            ).flow
        }
}
