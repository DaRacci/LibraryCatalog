<h1 align="left">Library Catalog
<a href="https://jitpack.io/#DaRacci/LibraryCatalog"><img src="https://jitpack.io/v/DaRacci/LibraryCatalog.svg?style=flat-square" alt="language"/></a>
</h1>

# About
Library Catalog is mainly designed for my own use, however it also provides a simple and clean way of it just works for dependencies.

## Inside gradle.settings.kts

```kotlin
enableFeaturePreview("VERSION_CATALOGS")
dependencyResolutionManagement {
    repositories {
        maven("https://jitpack.io")
    }
    versionCatalogs {
        create("libs") {
            from("com.github.DaRacci:LibraryCatalog:tag")
        }
    }
}
```
Replace `tag` with a release tag, eg `1.2`.
  
## Usage

```kotlin
dependencies {
    api(libs.adventure.api)
    api(libs.adventure.miniMessage)
        
    testImplementation(libs.jupiterAPI)
    testRuntimeOnly(libs.jupiterEngine)
}
```
If used within a subproject you must prefice libs with `rootProject.libs`
