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
                    apply("quality.ktlint")
                    apply("de.mannodermaus.android-junit5")
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
                    "implementation"(libs.koin)

                    //region Test
                    "testImplementation"(libs.junit)
                    "androidTestImplementation"(libs.androidx.junit)
                    "androidTestImplementation"(libs.androidx.espresso.core)
                    "testImplementation"(libs.bundles.test.koin)

                    // (Required) Writing and executing Unit Tests on the JUnit Platform
                    "testImplementation"(libs.junit.jupiter.api)
                    "testRuntimeOnly"(libs.junit.jupiter.engine)

                    // (Optional) If you need "Parameterized Tests"
                    "testImplementation"("org.junit.jupiter:junit-jupiter-params:5.9.3")

                    // (Optional) If you also have JUnit 4-based tests
                    "testImplementation"(libs.junit)
                    "testRuntimeOnly"("org.junit.vintage:junit-vintage-engine:5.9.3")
                    //endregion
                }
            }
        }
    }
}