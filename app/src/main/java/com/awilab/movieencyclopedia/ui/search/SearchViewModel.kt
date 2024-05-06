package com.awilab.movieencyclopedia.ui.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.launch

@OptIn(FlowPreview::class)
class SearchViewModel : ViewModel() {
    val keywordStateFlow = MutableStateFlow("")

    init {
        viewModelScope.launch {
            keywordStateFlow.debounce(500).collect { word ->
                println("===========================$word")
            }
        }
    }

    fun onSearch(keyword: String) {
        viewModelScope.launch {
            keywordStateFlow.value = keyword
            // TODO: Change stateFlow paging data flow, @see SearchMoviesViewModel & SearchMoviesPager.
        }
    }

    fun onClear() {
        viewModelScope.launch {
            keywordStateFlow.value = ""
        }
    }
}
