package com.awilab.movieencyclopedia.di

import com.awilab.data.di.dataModule
import com.awilab.movieencyclopedia.ui.movie.MovieViewModel
import com.awilab.movieencyclopedia.ui.search.SearchViewModel
import com.awilab.movieencyclopedia.ui.setting.SettingViewModel
import com.awilab.movieencyclopedia.ui.steam.SteamViewModel
import com.awilab.network.di.networkModule
import com.awilab.network.di.servicesModule
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val viewModule = module {
    singleOf(::MovieViewModel)
    singleOf(::SteamViewModel)
    singleOf(::SearchViewModel)
    singleOf(::SettingViewModel)
}

val appModules = listOf(
    dataModule,
    viewModule,
    networkModule,
    servicesModule,
)
