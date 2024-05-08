package com.awilab.movieencyclopedia.ui.search

import androidx.annotation.StringRes
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.awilab.movieencyclopedia.R
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.launch

@OptIn(FlowPreview::class)
class SearchViewModel : ViewModel() {
    val keywordStateFlow = MutableStateFlow("")

    init {
        viewModelScope.launch {
            keywordStateFlow.debounce(500)
                .filter { it.isNotBlank() }
                .collect { word ->
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

    @StringRes
    fun onWarningMsg(): Int {
        return R.string.lab_search_warning
    }
}
