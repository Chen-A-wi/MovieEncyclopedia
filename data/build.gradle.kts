plugins {
    alias(libs.plugins.android.library)
    id("plugins.base-lib")
    kotlin("plugin.serialization") version "1.9.0"
}

android {
    namespace = "com.awilab.data"
}

dependencies {
    implementation(libs.kotlinx.serialization.json)
    implementation(project(":common"))
    implementation(project(":network"))
    testImplementation(project(":testing"))
}
