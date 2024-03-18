package com.awilab.plugins.extension

import org.gradle.api.Project
import com.android.build.gradle.BaseExtension
import com.awilab.plugins.configs.Version
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.the

@Suppress("UnstableApiUsage")
internal fun Project.configureCompose(commonExtension: BaseExtension){
    commonExtension.apply {
        buildFeatures.compose = true
        composeOptions.kotlinCompilerExtensionVersion = Version.kotlinCompilerExtension

        val libs = the<org.gradle.accessors.dm.LibrariesForLibs>()
        dependencies {
            "implementation"(libs.bundles.compose)
            "implementation"(platform(libs.compose.bom))
            "androidTestImplementation"(platform(libs.compose.bom))
            "androidTestImplementation"(libs.androidx.compose.ui.test)
        }
    }
}