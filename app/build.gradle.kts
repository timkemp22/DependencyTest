plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.hilt)
}

android {
    namespace = "com.bet365.dependencytesting"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.bet365.dependencytesting"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.14"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
            excludes += "META-INF/gradle/incremental.annotation.processors"
            excludes += "META-INF/LICENSE.md"
            excludes += "META-INF/LICENSE-notice.md"
        }
    }
}

dependencies {

    implementation(libs.bundles.androidx)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.bundles.compose)

    implementation(libs.bundles.hilt)
    implementation(libs.bundles.kotlin)
    kapt(libs.hilt.compiler)
    implementation(libs.bundles.google.play.libraries)
    implementation(libs.okhttp)
    implementation(libs.bundles.google.general)
    implementation(libs.firebase.analytics)
    implementation(libs.firebase.messaging)
    implementation(libs.card.scanning)
    implementation(libs.androidx.worker.runtime)

    testImplementation(libs.junit)
    androidTestImplementation(libs.bundles.testing)
    androidTestImplementation(libs.androidx.junit.extension)
    androidTestImplementation(libs.androidx.espresso.core)
}
