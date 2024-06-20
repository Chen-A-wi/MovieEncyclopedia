package com.awilab.plugins.extension

import com.android.build.gradle.BaseExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.the

internal fun Project.configureCompose(commonExtension: BaseExtension){
    commonExtension.apply {
        val libs = the<org.gradle.accessors.dm.LibrariesForLibs>()

        dependencies {
            "implementation"(libs.compose.coil)
            "implementation"(libs.koin.compose)
            "implementation"(libs.compose.ui.preview)
            "implementation"(libs.compose.constraintlayout)
        }
    }
}