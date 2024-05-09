package com.awilab.data.repository.search

import com.awilab.common.QueryType
import com.awilab.data.BuildConfig
import com.awilab.network.api.search.SearchServices
import com.awilab.network.response.search.SearchResp
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response

class SearchTMDBRepo(
    private val searchServices: SearchServices,
) {
    suspend fun searchTMDB(searchType: QueryType, keyword: String): Flow<Response<SearchResp>> {
        return flow {
            emit(
                searchServices.searchTMDB(
                    keyword = keyword,
                    searchType = searchType.name.lowercase(),
                    apiKey = BuildConfig.API_KEY,
                ),
            )
        }
    }
}
