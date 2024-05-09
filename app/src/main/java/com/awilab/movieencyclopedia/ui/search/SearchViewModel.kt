package com.awilab.movieencyclopedia.ui.search

import androidx.annotation.StringRes
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.awilab.common.QueryType
import com.awilab.data.repository.search.SearchTMDBRepo
import com.awilab.movieencyclopedia.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

@OptIn(FlowPreview::class, ExperimentalCoroutinesApi::class)
class SearchViewModel(
    private val searchTMDBRepo: SearchTMDBRepo,
) : ViewModel() {
    val keywordStateFlow = MutableStateFlow("")

    init {
        viewModelScope.launch {
            keywordStateFlow.debounce(500)
                .filter { it.isNotBlank() }
                .collect { word ->
                    searchMovieAndTV(word)
                }
        }
    }

    fun onSearch(keyword: String) {
        viewModelScope.launch {
            keywordStateFlow.value = keyword
            // TODO: Change stateFlow paging data flow, @see SearchMoviesViewModel & SearchMoviesPager.
        }
    }

    fun searchMovieAndTV(word: String) {
        viewModelScope.launch {
            println("==========================$word")
            searchTMDBRepo.searchTMDB(searchType = QueryType.MOVIE, keyword = word)
                .flowOn(Dispatchers.IO)
                .collect {
                    println("==========================$it")
                }
        }
    }

    fun onClear() {
        viewModelScope.launch {
            keywordStateFlow.value = ""
        }
    }

    @StringRes
    fun onWarningMsg(): Int {
        return R.string.lab_search_warning
    }
}
