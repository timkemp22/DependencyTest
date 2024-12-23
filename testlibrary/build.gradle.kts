plugins {
alias(libs.plugins.kotlin.jvm)
}
//
//android {
//    namespace = "com.example.testlibrary"
//    compileSdk = 35
//
//    defaultConfig {
//        minSdk = 24
//
//        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
//        consumerProguardFiles("consumer-rules.pro")
//    }
//
//    buildTypes {
//        release {
//            isMinifyEnabled = false
//            proguardFiles(
//                getDefaultProguardFile("proguard-android-optimize.txt"),
//                "proguard-rules.pro"
//            )
//        }
//    }
//    compileOptions {
//        sourceCompatibility = JavaVersion.VERSION_1_8
//        targetCompatibility = JavaVersion.VERSION_1_8
//    }
//    kotlinOptions {
//        jvmTarget = "1.8"
//    }
//}
//
//dependencies {
//
//    compileOnly(libs.android.lint.api)
//    compileOnly(libs.android.lint.checks)
//    compileOnly(libs.kotlin.standard.jdk7)
//    implementation(libs.androidx.core.ktx)
//    implementation(libs.androidx.appcompat)
//    implementation(libs.google.material)
//    testImplementation(libs.junit)
//    androidTestImplementation(libs.androidx.junit.extension)
//    androidTestImplementation(libs.androidx.espresso.core)
//    testImplementation(libs.bundles.lintTesting)
//}
sourceSets {
    main {
        kotlin {
            exclude("")
        }
    }
}

dependencies {
    implementation(libs.kotlin.coroutines)
    implementation(libs.google.gson)
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>{
    kotlinOptions {
        jvmTarget = "17"
    }
}