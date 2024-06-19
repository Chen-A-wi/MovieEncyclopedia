package com.awilab.movieencyclopedia.ui.search

import com.awilab.domain.model.movie.Movie

data class SearchUiStatus(
    val movieList: List<Movie> = emptyList(),
)
