package com.example.gradleplugins

import com.android.build.api.dsl.CommonExtension
import extension.bundle
import extension.getVersionCatalog
import extension.library
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

internal fun Project.configureTestingDependencies(commonExtension: CommonExtension<*, *, *, *, *, *>) {
    val versionCatalog = getVersionCatalog()
    commonExtension.apply {
        dependencies {
            add("testImplementation", versionCatalog.library("junit"))
            add("androidTestImplementation", versionCatalog.bundle("testing"))
            add("androidTestImplementation", versionCatalog.library("androidx-junit-extension"))
            add("androidTestImplementation", versionCatalog.library("androidx-espresso-core"))
        }
    }
}