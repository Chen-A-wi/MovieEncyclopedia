package com.awilab.network.api.search

import retrofit2.http.GET
import retrofit2.http.Query

interface SearchServices {
    @GET("search/movie")
    suspend fun searchMovie(
        @Query("query") keyword: String,
        @Query("api_key") apiKey: String,
    )
}
