package com.awilab.plugins.plugins

import com.android.build.gradle.LibraryExtension
import com.awilab.plugins.configs.Version
import com.awilab.plugins.extension.buildTypes
import com.awilab.plugins.extension.kotlinOptions
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.exclude
import org.gradle.kotlin.dsl.the

class BaseLibPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            extensions.configure<LibraryExtension> {
                plugins.run {
                    apply("org.jetbrains.kotlin.android")
                }

                defaultConfig {
                    compileSdk = Version.compileSdk
                    minSdk = Version.minSdk

                    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                    consumerProguardFiles("consumer-rules.pro")
                }

                compileOptions {
                    sourceCompatibility = Version.jdk
                    targetCompatibility = Version.jdk
                }

                kotlinOptions {
                    jvmTarget = Version.jdk.toString()
                }

                buildTypes()

                val libs = the<org.gradle.accessors.dm.LibrariesForLibs>()

                dependencies {
                    "implementation"(libs.bundles.androidx)
                    "implementation"(libs.androidx.appcompat)
                    "implementation"(libs.material)
                    "testImplementation"(libs.junit)
                    "androidTestImplementation"(libs.androidx.junit)
                    "androidTestImplementation"(libs.androidx.espresso.core)
                }
            }
        }
    }
}