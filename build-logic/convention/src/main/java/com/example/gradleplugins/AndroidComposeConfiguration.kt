package com.example.gradleplugins

import com.android.build.api.dsl.CommonExtension
import extension.bundle
import extension.getVersionCatalog
import extension.library
import extension.version
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

internal fun Project.configureAndroidCompose(commonExtension: CommonExtension<*, *, *, *, *, *>) {
    val versionCatalog = getVersionCatalog()
    commonExtension.apply {
        buildFeatures {
            compose = true
        }

        composeOptions {
            kotlinCompilerExtensionVersion = "1.5.14"
        }
        dependencies {
            val bom = versionCatalog.library("androidx-compose-bom")
            add("implementation", platform(bom))
            add("implementation", versionCatalog.bundle("compose"))
            add("kapt", versionCatalog.library("hilt-compiler"))
            add("implementation", versionCatalog.bundle("androidx"))
            add("implementation", versionCatalog.bundle("hilt"))



        }
    }
}