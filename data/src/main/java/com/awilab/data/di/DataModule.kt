package com.awilab.data.di

import com.awilab.data.repository.query.QueryDetailsRepo
import com.awilab.data.repository.search.SearchTMDBRepo
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val dataModule = module {
    singleOf(::SearchTMDBRepo)
    singleOf(::QueryDetailsRepo)
}
