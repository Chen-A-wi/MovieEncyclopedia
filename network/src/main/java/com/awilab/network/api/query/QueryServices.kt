package com.awilab.network.api.query

import com.awilab.network.response.query.QueryResp
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface QueryServices {
    @GET("{query_type}/{id}")
    suspend fun queryDetail(
        @Path("query_type") queryType: String,
        @Path("id") id: String,
        @Query("api_key") apiKey: String,
    ): Response<QueryResp>
}
