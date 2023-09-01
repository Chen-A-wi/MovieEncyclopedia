package com.awilab.plugins.plugins

import com.android.build.api.dsl.ApplicationExtension
import com.awilab.plugins.configs.Version
import com.awilab.plugins.extension.kotlinOptions
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.the

class AppPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            extensions.configure<ApplicationExtension> {
                plugins.run {
                    apply("org.jetbrains.kotlin.android")
                    apply("quality.ktlint")
                }

                defaultConfig {
                    compileSdk = Version.compileSdk
                    minSdk = Version.minSdk
                    targetSdk = Version.targetSdk
                    versionCode = Version.versionCode
                    versionName = Version.versionName

                    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                    vectorDrawables {
                        useSupportLibrary = true
                    }
                }

                buildFeatures {
                    compose = true
                }

                compileOptions {
                    sourceCompatibility = Version.jdk
                    targetCompatibility = Version.jdk
                }

                composeOptions {
                    kotlinCompilerExtensionVersion = Version.kotlinCompilerExtension
                }

                kotlinOptions {
                    jvmTarget = "${Version.jdk}"
                }

                testOptions {
                    unitTests.isIncludeAndroidResources = true
                }

                packaging {
                    resources.excludes.apply {
                        add("META-INF/AL2.0")
                        add("META-INF/LGPL2.1")
                    }
                }

                val libs = the<org.gradle.accessors.dm.LibrariesForLibs>()

                dependencies {
                    "implementation"(libs.bundles.compose)
                    "implementation"(platform(libs.compose.bom))
                    "implementation"(libs.bundles.androidx)
                    "implementation"(platform(libs.kotlin.bom))
                    "implementation"(libs.koin)

                    //region Flipper
                    "debugImplementation"(libs.bundles.debug.flipper)
                    "releaseImplementation"(libs.flipper.noop)
                    //endregion

                    "testImplementation"(libs.bundles.test.koin)
                    "testImplementation"(libs.junit.jupiter.api)
                    "testRuntimeOnly"(libs.bundles.test.runtime.only)
                    "androidTestImplementation"(platform(libs.compose.bom))
                    "androidTestImplementation"(libs.bundles.android.test)
                    "debugImplementation"(libs.bundles.debug)
                }
            }
        }
    }
}