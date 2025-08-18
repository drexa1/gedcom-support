import org.jetbrains.intellij.platform.gradle.IntelliJPlatformType


version = "1.0.1"

plugins {
    id("org.jetbrains.intellij.platform") version "2.7.2"
}

repositories {
    mavenCentral()
    intellijPlatform {
        defaultRepositories()
    }
}

dependencies {
    intellijPlatform {
        val version = providers.gradleProperty("platformVersion")
        create(IntelliJPlatformType.IntellijIdeaUltimate, version) {
            useInstaller = true
        }
    }
}