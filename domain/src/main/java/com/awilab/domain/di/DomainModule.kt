package com.awilab.domain.di

import com.awilab.domain.usecase.SearchUseCase
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val useCaseModule = module {
    singleOf(::SearchUseCase)
}
