plugins {
    id("java")
    id("fabric-loom") version "1.1-SNAPSHOT"
}

repositories {
    mavenCentral()
}

dependencies {
    minecraft("com.mojang:minecraft:${project.properties["me.lucaslah.timechanger.fabric.minecraft_version"]}")
    mappings("net.fabricmc:yarn:${project.properties["me.lucaslah.timechanger.fabric.yarn_mappings"]}:v2")
    modImplementation("net.fabricmc:fabric-loader:${project.properties["me.lucaslah.timechanger.fabric.loader_version"]}")
    include(project(":api"))
    implementation(project(":api"))
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
    withSourcesJar()
}

tasks {
    processResources {
        inputs.property("version", project.version)

        filesMatching("fabric.mod.json") {
            expand(mutableMapOf("version" to project.version))
        }
    }

    jar {
        from("LICENSE")
    }
}
