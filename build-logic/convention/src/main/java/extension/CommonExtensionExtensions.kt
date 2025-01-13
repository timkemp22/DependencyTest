package extension

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.plugins.ExtensionAware
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions

internal fun CommonExtension<*, *, *, *, *, *>.kotlinOptions(configure: KotlinJvmOptions.() -> Unit): Unit =
    (this as ExtensionAware).extensions.configure("kotlinOptions", configure)

internal fun CommonExtension<*, *, *, *, *, *>.excludeResourcesFromPackaging() {
    packaging {
        resources {
            excludes += listOf(
                "/META-INF/{AL2.0,LGPL2.1}",
                "/META-INF/LICENSE.md",
                "META-INF/LICENSE-notice.md",
                "META-INF/gradle/incremental.annotation.processors",
                // This doesn't feel like the right solution, but resolves an issue with the manifest
                // trying to be packaged twice causing a conflict of overriding.
                "AndroidManifest.xml",
            )
        }
    }
}