plugins {
    alias(libs.plugins.kotlin.dsl)
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("compose"){
            id = "com.example.compose"
            implementationClass = "ComposeModuleConventionPlugin"
        }
        register("coreModule"){
            id = "com.example.coreModule"
            implementationClass = "CoreModuleConventionPlugin"
        }
        register("appModule"){
            id = "com.example.app"
            implementationClass = "AppModuleConventionPlugin"
        }
    }
}