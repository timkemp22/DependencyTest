plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.hilt)
    alias(libs.plugins.application)
    alias(libs.plugins.compose)
}

android {
    namespace = "com.testing.dependencytesting"
}

dependencies {
    implementation(libs.twilio){
        artifact {
            type = "aar"
        }
    }
    implementation(libs.getkeepsafe.relinker){
        artifact {
            type = "aar"
        }
    }

    implementation(libs.kotlin.standard.jdk7)

    implementation(libs.bundles.usLocation)
}
