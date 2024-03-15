import org.jetbrains.kotlin.konan.properties.Properties
import kotlin.properties.Delegates

plugins {
    id("com.android.application")
    id("plugins.app")
}

android {
    namespace = "com.awilab.movieencyclopedia"
    flavorDimensions += listOf("default")

    defaultConfig {
        applicationId = "com.awilab.movieencyclopedia"
    }

    buildFeatures {
        buildConfig = true
    }

    productFlavors {
        var apiKey by Delegates.notNull<String>()
        var apiToken by Delegates.notNull<String>()

        Properties().apply {
            load(project.rootProject.file("local.properties").inputStream())
            apiKey = getProperty("API_KEY")
            apiToken = getProperty("API_TOKEN")
        }

        create("dev") {
            resValue("string", "app_name", "(DEV)MovieEncyclopedia")
            buildConfigField("String", "API_KEY", apiKey)
            buildConfigField("String", "API_TOKEN", apiToken)
        }
        create("prod") {
            resValue("string", "app_name", "MovieEncyclopedia")
            buildConfigField("String", "API_KEY", apiKey)
            buildConfigField("String", "API_TOKEN", apiToken)
        }
    }
}

dependencies {
    implementation(project(":data"))
    implementation(project(":network"))
    implementation(libs.androidx.navigation)
}
