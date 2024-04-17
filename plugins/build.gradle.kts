plugins {
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
}

repositories {
    google()
    mavenCentral()
}

gradlePlugin {
    plugins {
        create("AppPlugin") {
            id = "plugins.app"
            implementationClass = "com.awilab.plugins.plugins.AppPlugin"
        }
        create("BaseLibPlugin") {
            id = "plugins.base-lib"
            implementationClass = "com.awilab.plugins.plugins.BaseLibPlugin"
        }
        create("ComposePlugin") {
            id = "plugins.compose"
            implementationClass = "com.awilab.plugins.plugins.ComposePlugin"
        }
        create("Ktlint") {
            id = "quality.ktlint"
            implementationClass = "com.awilab.plugins.quality.KtlintPlugin"
        }
    }
}

dependencies {
    implementation(libs.gradle.tools.build)
    implementation(libs.kotlin.gradle.plugin)
    implementation(files(libs.javaClass.superclass.protectionDomain.codeSource.location))
}