package com.awilab.data.di

import com.awilab.data.remote.api.TmdbSearchServices
import com.awilab.data.repository.search.SearchRepositoryImpl
import com.awilab.domain.repository.SearchRepository
import com.awilab.network.createService
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val servicesModule = module {
    single<TmdbSearchServices> { createService(get()) }
}

val dataModule = module {
    singleOf(::SearchRepositoryImpl) bind SearchRepository::class
}
