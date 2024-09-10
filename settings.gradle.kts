@file:Suppress("UnstableApiUsage")

pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
        includeBuild("plugins")
    }
}

// 官方issue rebuild fail，所以略過test
gradle.startParameter.excludedTaskNames.addAll(
    gradle.startParameter.taskNames.filter {
        it.contains("testClasses")
    }
)

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven {
            url = uri("https://plugins.gradle.org/m2/")
        }
    }
}

rootProject.name = "MovieEncyclopedia"
include(":app")
include(":data")
include(":domain")
include(":network")
include(":testing")
include(":common")
