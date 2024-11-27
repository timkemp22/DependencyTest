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
