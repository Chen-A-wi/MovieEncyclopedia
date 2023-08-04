plugins {
    id("com.android.application") version "8.1.0" apply false
    id("com.android.library") version "8.1.0" apply false
    id("org.jetbrains.kotlin.android") version "1.7.20" apply false
}

buildscript {
    repositories {
        mavenCentral()
        google()
    }
    dependencies {
        classpath(libs.gradle.tools.build)
    }
}