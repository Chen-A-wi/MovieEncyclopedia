package com.awilab.network.api.query

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface QueryServices {
    @GET("{query_type}/{id}")
    suspend fun queryDetail(
        @Path("query_type") queryType: String,
        @Path("id") id: String,
        @Query("api_key") apiKey: String,
    )
}
