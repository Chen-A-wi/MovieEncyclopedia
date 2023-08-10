package com.awilab.network.di

import com.awilab.network.api.search.SearchServices
import com.awilab.network.buildOkHttpClient
import com.awilab.network.configs.NetworkConfig
import com.awilab.network.createService
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val servicesModule = module {
    single<SearchServices> { createService(get(), NetworkConfig.BASE_URL) }
}

val networkModule = module {
    singleOf(::buildOkHttpClient)
}
