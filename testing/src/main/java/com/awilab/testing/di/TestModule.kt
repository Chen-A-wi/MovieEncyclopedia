package com.awilab.testing.di

import com.awilab.data.di.dataModule
import com.awilab.network.di.networkModule
import com.awilab.network.di.servicesModule

val testModules = listOf(
    dataModule,
    networkModule,
    servicesModule,
)
