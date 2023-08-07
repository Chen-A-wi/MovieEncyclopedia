plugins {
    id("com.android.application")
    id("plugins.app")
}

android {
    namespace = "com.awilab.movieencyclopedia"

    defaultConfig {
        applicationId = "com.awilab.movieencyclopedia"
    }
}

dependencies {
    implementation(project(":data"))
    implementation(project(":network"))
}
