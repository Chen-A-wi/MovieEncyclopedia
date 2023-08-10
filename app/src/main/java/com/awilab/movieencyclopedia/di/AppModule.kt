package com.awilab.movieencyclopedia.di

import com.awilab.data.di.dataModule
import com.awilab.network.di.networkModule
import com.awilab.network.di.servicesModule

val appModules = listOf(
    dataModule,
    networkModule,
    servicesModule,
)
