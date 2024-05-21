package com.awilab.network.di

import com.awilab.network.buildOkHttpClient
import com.awilab.network.createLogInterceptor
import com.awilab.network.createMockWebServer
import com.awilab.network.mock.MockWebDispatcher
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val networkModule = module {
    singleOf(::createLogInterceptor)
    singleOf(::buildOkHttpClient)
    singleOf(::createMockWebServer)
    singleOf(::MockWebDispatcher)
}
