package com.awilab.network.mock

import com.awilab.common.extension.safeLet
import okhttp3.HttpUrl
import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.RecordedRequest
import kotlin.properties.Delegates

class MockWebDispatcher : Dispatcher() {
    override fun dispatch(request: RecordedRequest): MockResponse {
        var requestPath by Delegates.notNull<String>()
        var requestUrl by Delegates.notNull<HttpUrl>()

        safeLet(request.method, request.path, request.requestUrl) { method, path, url ->
            requestPath = path
            requestUrl = url
        }

        return when {
            requestPath.contains("search/movie") && request.method.orEmpty() == "GET" -> {
                mockResp(assetsPath = "")
            }
            else -> MockResponse()
        }
    }

    private fun mockResp(respCode: Int = 200, assetsPath: String): MockResponse {
        return MockResponse()
            .setResponseCode(respCode)
            .addHeader("Content-Type", "application/json;charset=utf-8")
    }
}
