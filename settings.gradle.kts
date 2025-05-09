pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode = RepositoriesMode.FAIL_ON_PROJECT_REPOS
    repositories {
        google()
        mavenCentral()
    }
}

// Root project name and a subproject name can not being the same
// See https://github.com/gradle/gradle/issues/16608
rootProject.name = "kavoshgar-project"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

include(":demo")
include(":kavoshgar")
