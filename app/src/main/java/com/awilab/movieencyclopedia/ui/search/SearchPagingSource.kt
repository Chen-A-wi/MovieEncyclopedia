package com.awilab.movieencyclopedia.ui.search

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.awilab.domain.model.movie.Movie

class SearchPagingSource : PagingSource<Int, Movie>() {
    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? {
        TODO("Not yet implemented")
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
        TODO("Not yet implemented")
    }
}
