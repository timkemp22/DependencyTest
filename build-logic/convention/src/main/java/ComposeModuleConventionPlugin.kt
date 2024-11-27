import com.android.build.api.dsl.ApplicationExtension
import com.android.build.gradle.LibraryExtension
import com.android.tools.r8.CompilationFailedException
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType
import com.example.gradleplugins.configureAndroidCompose

class ComposeModuleConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            when {
                plugins.hasPlugin("com.android.application") -> {
                    extensions.getByType<ApplicationExtension>()
                        .run(::configureAndroidCompose)
                }

                plugins.hasPlugin("com.android.library") -> {
                    extensions.getByType<LibraryExtension>()
                        .run(::configureAndroidCompose)
                }

                else -> {
                    throw CompilationFailedException(
                        "Attempting to apply compose to a module that isn't an app or library module"
                    )
                }
            }
        }
    }
}