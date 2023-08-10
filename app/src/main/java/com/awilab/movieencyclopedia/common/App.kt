package com.awilab.movieencyclopedia.common

import android.app.Application
import com.awilab.movieencyclopedia.di.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@App)
            modules(appModules)
        }
    }
}
