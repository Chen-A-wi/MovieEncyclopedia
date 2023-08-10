plugins {
    alias(libs.plugins.android.library)
    id("plugins.base-lib")
}

android {
    namespace = "com.awilab.testing"
}

dependencies {
    implementation(project(":data"))
    implementation(project(":network"))
    implementation("com.google.truth:truth:1.1.4")
}
