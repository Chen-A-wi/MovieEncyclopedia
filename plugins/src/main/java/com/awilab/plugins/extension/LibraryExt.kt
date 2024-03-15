package com.awilab.plugins.extension

import com.android.build.api.dsl.LibraryExtension

fun LibraryExtension.buildTypes() {
    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles("proguard-android-optimize.txt", "proguard-rules.pro")
            consumerProguardFiles("proguard-rules.pro")
        }

        debug {

        }
    }
}