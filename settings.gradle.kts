dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.PREFER_PROJECT)
    repositories {
        gradlePluginPortal()
        mavenCentral()
    }
}

pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
}
plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
    id("io.insert-koin.compiler.plugin") version "1.0.2" apply false
}

rootProject.name = "leetcode-solutions"
include(":domain")
include("cli-navigation")
include("data")