package com.awilab.data.repository.search

import com.awilab.data.BuildConfig
import com.awilab.network.api.search.SearchServices
import com.awilab.network.response.search.SearchMovieResp
import retrofit2.Response

class SearchMovieRepo(
    private val searchServices: SearchServices,
) {
    suspend fun searchMovie(keyword: String): Response<SearchMovieResp> {
        return searchServices.searchMovie(
            keyword = keyword,
            apiKey = BuildConfig.API_KEY,
        )
    }
}
