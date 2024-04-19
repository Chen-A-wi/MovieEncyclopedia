package com.awilab.movieencyclopedia.di

import androidx.lifecycle.viewmodel.compose.viewModel
import com.awilab.data.di.dataModule
import com.awilab.movieencyclopedia.ui.search.SearchViewModel
import com.awilab.network.di.networkModule
import com.awilab.network.di.servicesModule
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val viewModule = module {
    viewModelOf(::SearchViewModel)
}

val appModules = listOf(
    dataModule,
    networkModule,
    servicesModule,
)
