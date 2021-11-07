plugins {
    java
    `maven-publish`
    `version-catalog`
}

catalog {
    versionCatalog {
        // Kyori Adventure
        alias("adventure-API").to("net.kyori:adventure-api:4.10.0-SNAPSHOT")
        alias("adventure-miniMessage").to("net.kyori:adventure-text-minimessage:4.2.0-SNAPSHOT")
        // Minecraft
        alias("authLib").to("com.mojang:authlib:1.5.21")
        alias("purpurAPI").to("net.pl3x.purpur:purpur-api:1.17.1-R0.1-SNAPSHOT")
        // Plugin APIs
        alias("plugin-luckPermsAPI").to("net.luckperms:api:5.3")
        alias("plugin-placeholderAPI").to("me.clip:placeholderapi:2.10.10")
        alias("plugin-landsAPI").to("com.github.angeschossen:LandsAPI:5.15.2")
        alias("plugin-protocolLib").to("com.comphenix.protocol:ProtocolLib:4.7.0")
        alias("plugin-citizensAPI").to("net.citizensnpcs:citizens-main:2.0.28-SNAPSHOT")
        alias("plugin-ecoEnchants").to("com.github.Auxilor:EcoEnchants:8.14.0")
        alias("plugin-multiverseCore").to("com.onarandombox.multiversecore:Multiverse-Core:4.3.1")
        alias("plugin-vault").to("com.github.MilkBowl:VaultAPI:1.7")
        // Kotlin Libs
        alias("kotlin-stdLib").to("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.6.0-M1")
        alias("kotlin-reflect").to("org.jetbrains.kotlin:kotlin-reflect:1.6.0-M1")
        alias("kotlinX-datetime").to("org.jetbrains.kotlinx:kotlinx-datetime:0.3.0")
        alias("kotlinX-serialization").to("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.0")
        alias("kotlinX-coroutinesCore").to("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.2-native-mt")
        alias("kotlinX-coroutinesJvm").to("org.jetbrains.kotlinx:kotlinx-coroutines-core-jvm:1.5.2-native-mt")
        // Libraries
        alias("nbtInjector").to("de.tr7zw:data-injector:2.8.0")
        alias("dataNBTAPI").to("de.tr7zw:nbt-data-api:2.8.0")
        alias("itemNBTAPI").to("de.tr7zw:item-nbt-api:2.8.0")
        alias("acfPaper").to("co.aikar:acf-paper:0.5.0-SNAPSHOT")
        alias("inventoryFramework").to("com.github.stefvanschie.inventoryframework:IF:0.10.3")
        alias("mcCoroutineAPI").to("com.github.shynixn.mccoroutine:mccoroutine-bukkit-api:1.5.0")
        alias("mcCoroutineCore").to("com.github.shynixn.mccoroutine:mccoroutine-bukkit-core:1.5.0")
        // Tests
        alias("jupiterAPI").to("org.junit.jupiter:junit-jupiter-api:5.8.1")
        alias("jupiterEngine").to("org.junit.jupiter:junit-jupiter-engine:5.8.1")
        // Bundles
        bundle("kyoriAdventure", listOf("adventure-API", "adventure-miniMessage"))
        bundle("kotlinLibs", listOf("kotlin-stdLib", "kotlin-reflect"))
        bundle("kotlinXLibs", listOf("kotlinX-datetime", "kotlinX-serialization", "kotlinX-coroutinesCore", "kotlinX-coroutinesJvm"))
        bundle("mcCoroutine", listOf("mcCoroutineAPI", "mcCoroutineCore"))
        bundle("nbtLibs", listOf("nbtInjector", "dataNBTAPI", "itemNBTAPI"))
    }
}

tasks.build {
    dependsOn(tasks.generateCatalogAsToml)
}

publishing {
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/DaRacci/LibraryCatalog")
            credentials {
                username = "DaRacci"
                password = System.getenv("TOKEN")
            }
        }
    }

    publications {
        create<MavenPublication>("catalog") {
            from(components["versionCatalog"])
        }
    }
}

group = "me.racci"
version = "1.0"