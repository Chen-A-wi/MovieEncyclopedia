@file:Suppress("UnstableApiUsage")

package com.awilab.plugins.plugins

import com.android.build.api.dsl.ApplicationExtension
import com.awilab.plugins.configs.Version
import com.awilab.plugins.extension.configureAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.the

class AppPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("org.jetbrains.kotlin.android")
                apply("quality.ktlint")
            }

            extensions.configure<ApplicationExtension> {
                defaultConfig {
                    targetSdk = Version.targetSdk
                    versionCode = Version.versionCode
                    versionName = Version.versionName

                    vectorDrawables {
                        useSupportLibrary = true
                    }
                }

                configureAndroid()

                buildTypes {
                    release {
                        isMinifyEnabled = true
                        proguardFiles("proguard-android-optimize.txt", "proguard-rules.pro")
                    }

                    debug {

                    }
                }

                packaging {
                    resources.excludes.apply {
                        add("META-INF/AL2.0")
                        add("META-INF/LGPL2.1")
                    }
                }
            }

            val libs = the<org.gradle.accessors.dm.LibrariesForLibs>()
            dependencies {
                "implementation"(libs.bundles.androidx)
                "implementation"(platform(libs.kotlin.bom))
                "implementation"(libs.koin)

                "testImplementation"(libs.bundles.test.koin)
                "testImplementation"(libs.junit.jupiter.api)
                "testRuntimeOnly"(libs.bundles.test.runtime.only)
                "androidTestImplementation"(libs.bundles.android.test)
                "debugImplementation"(libs.bundles.debug)
            }
        }
    }
}