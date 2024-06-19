package com.awilab.movieencyclopedia.ui.search

import androidx.annotation.StringRes
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.awilab.domain.repository.SearchRepository
import com.awilab.movieencyclopedia.R
import com.awilab.network.response.common.Result
import com.awilab.network.response.common.asResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@OptIn(FlowPreview::class, ExperimentalCoroutinesApi::class)
class SearchViewModel(
    private val searchRepository: SearchRepository,
) : ViewModel() {
    val keywordStateFlow = MutableStateFlow("")
    private val searchPage: MutableStateFlow<Int> = MutableStateFlow(0)
    private val _uiState = MutableStateFlow(initUiState())
    val uiState: StateFlow<SearchUiStatus> = _uiState.asStateFlow()

    private fun initUiState(): SearchUiStatus {
        return SearchUiStatus()
    }

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
        }
    }

    fun searchMovieAndTV(query: String) {
        viewModelScope.launch {
            searchRepository.searchMovies(query = query, page = 1, language = "en").asResult()
                .flowOn(Dispatchers.IO).collect {
                    when (it) {
                        is Result.Error -> {
                            println("${it.exception.message}")
                        }

                        Result.Loading -> {
                        }

                        is Result.Success -> {
                            _uiState.update { state ->
                                state.copy(
                                    movieList = it.data.results,
                                )
                            }
                            println("=====================${it.data.results.first()}")
                        }
                    }
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
