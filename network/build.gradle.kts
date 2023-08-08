plugins {
    alias(libs.plugins.android.library)
    id("plugins.base-lib")
}

android {
    namespace = "com.awilab.network"
}

dependencies {
    implementation(libs.okhttp)
    implementation(libs.okhttp.logging)
    implementation(libs.retrofit2)

    testImplementation(libs.test.mockwebserver)
}
