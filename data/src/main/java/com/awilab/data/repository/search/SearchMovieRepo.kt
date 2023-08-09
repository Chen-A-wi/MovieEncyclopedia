package com.awilab.data.repository.search

import com.awilab.network.api.search.SearchServices
import com.awilab.network.response.BaseResp
import com.awilab.network.response.search.SearchMovieResp

class SearchMovieRepo(
    private val searchServices: SearchServices,
) {
    suspend fun searchMovie(keyword: String): BaseResp<SearchMovieResp> {
        return searchServices.searchMovie(
            keyword = keyword,
            apiKey = "30475441afb1c0a41ed69133fe8b35af",
        )
    }
}
