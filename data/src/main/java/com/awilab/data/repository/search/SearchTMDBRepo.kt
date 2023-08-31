package com.awilab.data.repository.search

import com.awilab.common.QueryType
import com.awilab.data.BuildConfig
import com.awilab.network.api.search.SearchServices
import com.awilab.network.response.search.SearchResp
import retrofit2.Response

class SearchTMDBRepo(
    private val searchServices: SearchServices,
) {
    suspend fun searchTMDB(searchType: QueryType, keyword: String): Response<SearchResp> {
        return searchServices.searchTMDB(
            keyword = keyword,
            searchType = searchType.name.lowercase(),
            apiKey = BuildConfig.API_KEY,
        )
    }
}
