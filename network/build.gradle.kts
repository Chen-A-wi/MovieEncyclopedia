plugins {
    alias(libs.plugins.android.library)
    id("plugins.base-lib")
    kotlin("plugin.serialization") version "1.9.0"
}

android {
    namespace = "com.awilab.network"
}

dependencies {
    implementation(libs.okhttp)
    implementation(libs.okhttp.logging)
    implementation(libs.retrofit2)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.test.mockwebserver)
    implementation(project(":common"))
}
