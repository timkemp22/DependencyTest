package model

object BuildProperties {
    const val PACKAGE_NAME = "com.testing.dependencytesting"
    const val TARGET_SDK = 35
    const val COMPILE_SDK = 35
    const val MIN_SDK = 26
    val versionCode: Int
        get() = System.getenv("FUELED_BUILD_NUMBER")?.toInt() ?: 1
    val versionName: String
        get() = System.getenv("BUILD_VERSION_NAME") ?: "0.0.1"
}