plugins {
    alias(libs.plugins.android.library)
    id(libs.plugins.base.library.get().pluginId)
}

android {
    namespace = "com.awilab.common"
}

dependencies {
}
