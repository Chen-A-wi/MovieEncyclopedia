package com.awilab.network

import com.awilab.common.configs.CommonConfig
import com.awilab.network.configs.NetworkConfig
import com.awilab.network.mock.MockWebDispatcher
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.ConnectionPool
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Protocol
import okhttp3.mockwebserver.MockWebServer
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

inline fun <reified T> createService(
    okHttpClient: OkHttpClient,
    url: String = NetworkConfig.BASE_URL,
): T {
    val baseUrl = if (CommonConfig.isMock) {
        CommonConfig.MOCK_API_URL
    } else {
        url
    }

    return buildRetrofit(baseUrl, okHttpClient).create(T::class.java)
}

fun buildRetrofit(
    baseUrl: String,
    okHttpClient: OkHttpClient,
): Retrofit {
    return Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(okHttpClient)
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .build()
}

fun createMockWebServer(dispatcher: MockWebDispatcher): MockWebServer {
    val mockWebServer = MockWebServer()
    mockWebServer.dispatcher = dispatcher
    return mockWebServer
}

fun buildOkHttpClient(): OkHttpClient {
    return OkHttpClient.Builder()
        .retryOnConnectionFailure(true)
//        .addNetworkInterceptor(LoggerInterceptor())
        .connectTimeout(60L, TimeUnit.SECONDS)
        .readTimeout(60L, TimeUnit.SECONDS)
        .connectionPool(ConnectionPool(0, 1, TimeUnit.NANOSECONDS))
        .protocols(listOf(Protocol.HTTP_1_1))
        .build()
}
