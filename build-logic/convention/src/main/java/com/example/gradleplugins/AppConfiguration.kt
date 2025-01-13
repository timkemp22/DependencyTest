package com.example.gradleplugins

import com.android.build.api.dsl.CommonExtension
import extension.bundle
import extension.getVersionCatalog
import extension.library
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

internal fun Project.configureAddModule(
    commonExtension: CommonExtension<*, *, *, *, *, *>
) {
    val versionCatalog = getVersionCatalog()

    commonExtension.apply {
        dependencies {
            add("implementation", versionCatalog.library("okhttp"))
            add("implementation", versionCatalog.bundle("google-general"))
            add("implementation", versionCatalog.library("card-scanning"))
            add("implementation", versionCatalog.bundle("firebase"))
            add("implementation", versionCatalog.bundle("braze"))
            add("implementation", versionCatalog.bundle("google-play-libraries"))
            add("implementation", versionCatalog.library("androidx-worker-runtime"))
            add("compileOnly", versionCatalog.bundle("lint"))
        }
    }
}