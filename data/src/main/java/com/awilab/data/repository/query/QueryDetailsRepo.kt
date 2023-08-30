package com.awilab.data.repository.query

import com.awilab.common.QueryType
import com.awilab.data.BuildConfig
import com.awilab.network.api.query.QueryServices

class QueryDetailsRepo(
    private val queryServices: QueryServices,
) {
    suspend fun queryDetails(queryType: QueryType, id: String) {
        queryServices.queryDetail(
            id = id,
            apiKey = BuildConfig.API_KEY,
            queryType = queryType.name.lowercase(),
        )
    }
}
