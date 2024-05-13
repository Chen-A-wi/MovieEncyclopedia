package com.awilab.network.di

import com.awilab.network.api.query.QueryServices
import com.awilab.network.api.search.SearchServices
import com.awilab.network.buildOkHttpClient
import com.awilab.network.createLogInterceptor
import com.awilab.network.createMockWebServer
import com.awilab.network.createService
import com.awilab.network.mock.MockWebDispatcher
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val servicesModule = module {
    single<SearchServices> { createService(get()) }
    single<QueryServices> { createService(get()) }
}

val networkModule = module {
    singleOf(::createLogInterceptor)
    singleOf(::buildOkHttpClient)
    singleOf(::createMockWebServer)
    singleOf(::MockWebDispatcher)
}
