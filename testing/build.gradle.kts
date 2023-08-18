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
    implementation(project(":common"))
    implementation(libs.truth)
    implementation(libs.test.mockwebserver)
}
