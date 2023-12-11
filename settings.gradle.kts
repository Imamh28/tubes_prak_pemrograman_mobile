pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "tubes_ppm"
include(":app")
//<<<<<<< HEAD
//include(":crudrealtime")
//=======
//
//>>>>>>> 5793b9cc6a36ce57c5719565d26d6d5423d8b647
include(":crudadmin")
