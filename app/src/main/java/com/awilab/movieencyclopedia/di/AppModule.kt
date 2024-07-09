package com.awilab.movieencyclopedia.di

import com.awilab.data.di.dataModule
import com.awilab.data.di.servicesModule
import com.awilab.domain.di.useCaseModule
import com.awilab.movieencyclopedia.ui.movie.MovieViewModel
import com.awilab.movieencyclopedia.ui.search.SearchPager
import com.awilab.movieencyclopedia.ui.search.SearchViewModel
import com.awilab.movieencyclopedia.ui.setting.SettingViewModel
import com.awilab.movieencyclopedia.ui.steam.SteamViewModel
import com.awilab.network.di.networkModule
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val viewModule = module {
    viewModelOf(::MovieViewModel)
    viewModel {
        SearchViewModel(SearchPager(searchRepository = get()))
    }
    viewModelOf(::SteamViewModel)
    viewModelOf(::SettingViewModel)
}

val appModules = listOf(
    dataModule,
    useCaseModule,
    viewModule,
    networkModule,
    servicesModule,
)
