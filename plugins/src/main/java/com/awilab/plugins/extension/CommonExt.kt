package com.awilab.plugins.extension

import com.android.build.api.dsl.CommonExtension
import com.awilab.plugins.configs.Version
import org.gradle.api.plugins.ExtensionAware
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions

internal fun CommonExtension<*, *, *, *, *, *>.kotlinOptions(block: KotlinJvmOptions.() -> Unit) {
    (this as ExtensionAware).extensions.configure("kotlinOptions", block)
}

@Suppress("UnstableApiUsage")
internal fun CommonExtension<*, *, *, *, *, *>.configureAndroid() {
    apply {
        defaultConfig {
            compileSdk = Version.compileSdk
            minSdk = Version.minSdk

            testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        }

        compileOptions {
            sourceCompatibility = Version.jdk
            targetCompatibility = Version.jdk
        }

        kotlinOptions {
            jvmTarget = "${Version.jdk}"
        }

        testOptions {
            unitTests.isIncludeAndroidResources = true
        }

        buildFeatures {
            buildConfig = true
        }
    }
}
