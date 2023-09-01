package com.awilab.movieencyclopedia.common

import android.app.Application
import com.awilab.movieencyclopedia.BuildConfig
import com.awilab.movieencyclopedia.di.appModules
import com.facebook.flipper.android.AndroidFlipperClient
import com.facebook.flipper.android.utils.FlipperUtils
import com.facebook.flipper.plugins.crashreporter.CrashReporterPlugin
import com.facebook.flipper.plugins.inspector.DescriptorMapping
import com.facebook.flipper.plugins.inspector.InspectorFlipperPlugin
import com.facebook.soloader.SoLoader
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        initKoin()
        initFlipper()
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@App)
            modules(appModules)
        }
    }

    private fun initFlipper() {
        SoLoader.init(this, false)

        if (BuildConfig.DEBUG && FlipperUtils.shouldEnableFlipper(this)) {
            val client = AndroidFlipperClient.getInstance(this)

            client.run {
                addPlugin(InspectorFlipperPlugin(this@App, DescriptorMapping.withDefaults()))
                addPlugin(CrashReporterPlugin.getInstance())
                start()
            }
        }
    }
}
