package extension

import org.gradle.api.artifacts.ExternalModuleDependencyBundle
import org.gradle.api.artifacts.MinimalExternalModuleDependency
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.provider.Provider
import java.lang.Runtime.Version

internal fun VersionCatalog.library(versionCatalogName: String): Provider<MinimalExternalModuleDependency> {
    return findLibrary(versionCatalogName).get()
}

internal fun VersionCatalog.version(alias: String): String {
    return findVersion(alias).get().toString()
}

internal fun VersionCatalog.bundle(bundleName: String): Provider<ExternalModuleDependencyBundle> {
    return findBundle(bundleName).get()
}