plugins {
    alias(libs.plugins.android.library)
    id("plugins.base-lib")
}

android {
    namespace = "com.awilab.testing"
}

dependencies {
    implementation(project(":data"))
}
