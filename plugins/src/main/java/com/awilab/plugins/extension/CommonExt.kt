package com.awilab.plugins.extension

import com.android.build.api.dsl.CommonExtension
import com.awilab.plugins.configs.Version

@Suppress("UnstableApiUsage")
internal fun CommonExtension<*, *, *, *, *, *>.configureAndroid() {
    apply {
        defaultConfig {
            compileSdk = Version.COMPILE_SDK
            minSdk = Version.MIN_SDK

            testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        }

        compileOptions {
            sourceCompatibility = Version.jdk
            targetCompatibility = Version.jdk
        }

        testOptions {
            unitTests.isIncludeAndroidResources = true
        }

        buildFeatures {
            buildConfig = true
        }
    }
}
