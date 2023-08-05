package com.awilab.plugins.plugins

import com.android.build.gradle.LibraryExtension
import com.awilab.plugins.extension.buildTypes
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.the

class LibCommonPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            extensions.configure<LibraryExtension> {
                buildTypes()

                val libs = the<org.gradle.accessors.dm.LibrariesForLibs>()
            }
        }
    }
}