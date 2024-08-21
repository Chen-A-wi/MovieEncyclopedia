package com.awilab.movieencyclopedia.ui.search

import androidx.annotation.StringRes
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.awilab.movieencyclopedia.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class SearchViewModel(
    private val pager: SearchPager,
) : ViewModel() {
    private val _uiState = MutableStateFlow(initUiState())
    val uiState: StateFlow<SearchUiStatus> = _uiState.asStateFlow()
    private val _query = MutableStateFlow("")
    val searchQuery = _query.asStateFlow().onEach { pager.query.value = it }

    val searchResults = pager.pagingDataFlow
        .catch { error -> println("================ searchResults error: $error") }
        .cachedIn(viewModelScope)

    private fun initUiState(): SearchUiStatus {
        return SearchUiStatus()
    }

    fun onSearch(keyword: String) {
        viewModelScope.launch {
            _query.value = keyword
        }
    }

    fun onClear() {
        viewModelScope.launch {
            _query.value = ""
        }
    }

    @StringRes
    fun onWarningMsg(): Int {
        return R.string.lab_search_warning
    }
}
