package com.example.gradleplugins

import com.android.build.api.dsl.CommonExtension
import extension.bundle
import extension.getVersionCatalog
import extension.kotlinOptions
import extension.library
import model.BuildProperties
import org.gradle.api.JavaVersion.VERSION_1_8
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.provideDelegate

internal fun Project.configureKotlinAndroid(
    commonExtension: CommonExtension<*, *, *, *, *, *>
) {
    val versionCatalog = getVersionCatalog()
    commonExtension.apply {
        compileSdk = BuildProperties.COMPILE_SDK

        defaultConfig {
            minSdk = BuildProperties.MIN_SDK
        }

        compileOptions {
            sourceCompatibility = VERSION_1_8
            targetCompatibility = VERSION_1_8
        }

        kotlinOptions {
            // Treat all Kotlin warnings as errors (disabled by default)
            // Override by setting warningsAsErrors=true in your ./gradle/gradle.properties
            val warningsAsErrors: String? by project
            allWarningsAsErrors = warningsAsErrors.toBoolean()

            freeCompilerArgs = freeCompilerArgs + listOf(
                "-opt-in=kotlin.Experimental",
                "-opt-in=kotlinx.coroutines.ExperimentalCoroutinesApi",
            )
            jvmTarget = VERSION_1_8.toString()
        }

        dependencies {
            add("implementation", versionCatalog.bundle("androidx"))
            add("implementation", versionCatalog.bundle("kotlin"))
            add("implementation", versionCatalog.library("okhttp"))
            add("implementation", versionCatalog.bundle("google-general"))

        }
    }
}