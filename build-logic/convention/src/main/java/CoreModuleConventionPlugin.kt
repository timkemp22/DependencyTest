import com.android.build.gradle.LibraryExtension
import com.example.gradleplugins.configureKotlinAndroid
import extension.excludeResourcesFromPackaging
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class CoreModuleConventionPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        with(target){
            with(pluginManager){
                apply("com.android.library")
                apply("kotlin-android")
                apply("kotlin-kapt")
//                apply("com.google.dagger.hilt.android")
            }

            extensions.configure<LibraryExtension>(){
                configureKotlinAndroid(this)
                excludeResourcesFromPackaging()
            }
        }
    }
}