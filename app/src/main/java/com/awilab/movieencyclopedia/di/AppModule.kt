package com.awilab.movieencyclopedia.di

import com.awilab.data.di.dataModule
import com.awilab.network.di.networkModule
import com.awilab.network.di.servicesModule
import org.koin.dsl.module

val viewModule = module {
}

val appModules = listOf(
    dataModule,
    viewModule,
    networkModule,
    servicesModule,
)
