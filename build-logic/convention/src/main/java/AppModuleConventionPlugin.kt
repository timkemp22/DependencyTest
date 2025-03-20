import com.android.build.api.dsl.ApplicationExtension
import com.example.gradleplugins.configureAddModule
import com.example.gradleplugins.configureKotlinAndroid
import com.example.gradleplugins.configureTestingDependencies
import extension.excludeResourcesFromPackaging
import model.BuildProperties
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

internal class AppModuleConventionPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        with(target){
            with(plugins){
                apply("com.android.application")
                apply("kotlin-android")
                apply("com.google.dagger.hilt.android")
                apply("org.jetbrains.kotlin.plugin.compose")
            }
            extensions.configure<ApplicationExtension>(){
                excludeResourcesFromPackaging()
                // Adds common Android Dependencies
                configureKotlinAndroid(this)
                // Adds App Module Dependencies
                configureAddModule(this)
                // Adds Common Testing Dependencies
                configureTestingDependencies(this)
                defaultConfig {
                    applicationId = BuildProperties.PACKAGE_NAME
                    versionCode = BuildProperties.versionCode
                    versionName = BuildProperties.versionName
                    targetSdk = BuildProperties.TARGET_SDK
                    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                    vectorDrawables {
                        useSupportLibrary = true
                    }
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
            }
        }
    }
}