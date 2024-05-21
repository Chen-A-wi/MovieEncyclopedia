package com.awilab.data.remote.api

import com.awilab.data.remote.schema.MoviePaginatedSchema
import com.awilab.network.BuildConfig
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TmdbSearchServices {
    @GET("search/{search_type}")
    suspend fun searchTmdb(
        @Path("search_type") searchType: String,
        @Query("query") query: String,
        @Query("page") page: Int,
        @Query("language") language: String?,
        @Query("api_key") apiKey: String = BuildConfig.API_KEY,
    ): MoviePaginatedSchema
}
