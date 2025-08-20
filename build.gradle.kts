import org.jetbrains.intellij.platform.gradle.IntelliJPlatformType
import org.jetbrains.intellij.platform.gradle.tasks.PatchPluginXmlTask

group = "org.drexa1"
version = project.findProperty("version") ?: "1.0.0"

plugins {
    id("org.jetbrains.intellij.platform") version "2.7.2"
    kotlin("jvm") version "2.2.0"
}

repositories {
    mavenCentral()
    intellijPlatform {
        defaultRepositories()
    }
}

dependencies {
    implementation(kotlin("stdlib"))
    intellijPlatform {
        val version = providers.gradleProperty("platformVersion")
        create(IntelliJPlatformType.IntellijIdeaUltimate, version) {
            useInstaller = true
        }
    }
}

tasks.withType<PatchPluginXmlTask> {
    version = project.version.toString()
}