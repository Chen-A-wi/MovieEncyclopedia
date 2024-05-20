package com.awilab.network.api.search

import com.awilab.network.BuildConfig
import com.awilab.network.response.search.SearchResp
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface SearchServices {
    @GET("search/{search_type}")
    suspend fun searchTMDB(
        @Path("search_type") searchType: String,
        @Query("query") keyword: String,
        @Query("api_key") apiKey: String = BuildConfig.API_KEY,
    ): Response<SearchResp>
}
