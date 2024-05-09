import org.jetbrains.kotlin.konan.properties.Properties
import kotlin.properties.Delegates

plugins {
    id("com.android.application")
    id("plugins.app")
    id("plugins.compose")
    alias(libs.plugins.devtools.ksp)
}

android {
    namespace = "com.awilab.movieencyclopedia"
    flavorDimensions += listOf("default")

    defaultConfig {
        applicationId = "com.awilab.movieencyclopedia"
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

    applicationVariants.all {
        addJavaSourceFoldersToModel(
            File(
                layout.buildDirectory.asFile.get(),
                "generated/ksp/$name/kotlin",
            ),
        )
    }
}

dependencies {
    implementation(libs.bundles.material)
    implementation(libs.retrofit2)
    implementation(project(":common"))
    implementation(project(":data"))
    implementation(project(":network"))

    //region Compose destinations
    ksp(libs.compose.destinations.ksp)
    implementation(libs.compose.destinations.core)
    implementation(libs.compose.destinations.bottom.sheet)
    //endregion
}
