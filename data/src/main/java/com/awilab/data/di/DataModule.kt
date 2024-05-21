package com.awilab.data.di

import com.awilab.data.remote.api.TmdbSearchServices
import com.awilab.data.repository.query.QueryDetailsRepo
import com.awilab.data.repository.search.SearchRepositoryImpl
import com.awilab.domain.repository.SearchRepository
import com.awilab.network.createService
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val dataModule = module {
    single<TmdbSearchServices> { createService(get()) }

    singleOf(::QueryDetailsRepo)
    singleOf(::SearchRepositoryImpl) bind SearchRepository::class
}
