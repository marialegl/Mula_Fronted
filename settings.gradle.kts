pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven (url = "https://jitpack.io")
    }
    //versionCatalogs {
        //create("libs") {
            //from(files("gradle/libs.versions.toml")) // Aquí solo haces un llamado 'from'
        //}
    //}
}

rootProject.name = "LaMulaAppC"
include(":androidApp")
include(":shared")
