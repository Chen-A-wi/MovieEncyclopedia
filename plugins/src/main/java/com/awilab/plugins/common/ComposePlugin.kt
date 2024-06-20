package com.awilab.plugins.common

import com.android.build.gradle.BaseExtension
import com.awilab.plugins.extension.configureCompose
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType
import org.gradle.kotlin.dsl.the

class ComposePlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            val libs = the<org.gradle.accessors.dm.LibrariesForLibs>()

            with(pluginManager) {
                apply(libs.plugins.compose.compiler.get().pluginId)
            }

            configureCompose(extensions.getByType<BaseExtension>())
        }
    }
}