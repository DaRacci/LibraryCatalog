<h1 align="left">Library Catalog
<a href="https://jitpack.io/#DaRacci/LibraryCatalog"><img src="https://jitpack.io/v/DaRacci/LibraryCatalog.svg?style=flat-square" alt="language"/></a>
</h1>

# About
Library Catalog is mainly designed for my own use, however it also provides a simple and clean way of it just works for dependencies.

## Inside C:\Users\USER\.gradle\gradle.properties
```properties
USERNAME=YOUR_GITHUB_USER
TOKEN=YOUR_GITHUB_API_TOKEN
```

To get a Github API token go [here](https://github.com/settings/tokens),
and generate a new token with `read:packages`.
Apologies for doing it this way, however i cannot figure out how to get JitPack to publish it with the toml file artifact.

## Inside gradle.settings.kts

```kotlin
enableFeaturePreview("VERSION_CATALOGS")
val USERNAME: String by settings
val TOKEN: String by settings
dependencyResolutionManagement {
    repositories {
        maven {
            url = uri("https://maven.pkg.github.com/DaRacci/LibraryCatalog")
            credentials {
                username = USERNAME
                password = TOKEN
            }
        }
    }
    versionCatalogs {
        create("libs") {
            from("me.racci:librarycatalog:tag")
        }
    }
}
```
Replace `tag` with a release tag, eg `1.3`.
  
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
