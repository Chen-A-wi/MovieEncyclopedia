plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.jetbrains.kotlin) apply false
    alias(libs.plugins.jetbrains.jvm) apply false
    alias(libs.plugins.compose.compiler) apply false
}

buildscript {
    repositories {
        mavenCentral()
        google()
        maven(url = "https://jitpack.io")
    }
    dependencies {
        classpath(libs.gradle.tools.build)
        classpath(libs.android.junit5)
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}