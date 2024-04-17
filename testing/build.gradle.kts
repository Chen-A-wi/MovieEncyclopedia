plugins {
    alias(libs.plugins.android.library)
    id(libs.plugins.base.library.get().pluginId)
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
