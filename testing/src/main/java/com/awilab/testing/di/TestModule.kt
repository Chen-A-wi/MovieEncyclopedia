package com.awilab.testing.di

import com.awilab.common.utils.AssetsReader
import com.awilab.data.di.dataModule
import com.awilab.data.di.servicesModule
import com.awilab.network.di.networkModule
import com.awilab.testing.utils.TestAssetsReaderImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val assetsReaderModule = module {
    singleOf(::TestAssetsReaderImpl) bind AssetsReader::class
}

val testModules = listOf(
    assetsReaderModule,
    dataModule,
    networkModule,
    servicesModule,
)
