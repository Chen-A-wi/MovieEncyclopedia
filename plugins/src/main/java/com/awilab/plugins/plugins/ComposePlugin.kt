package com.awilab.plugins.plugins

import com.android.build.gradle.BaseExtension
import com.awilab.plugins.extension.configureCompose
import org.gradle.api.Plugin
import org.gradle.kotlin.dsl.getByType
import org.gradle.api.Project

class ComposePlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            configureCompose(extensions.getByType<BaseExtension>())
        }
    }
}