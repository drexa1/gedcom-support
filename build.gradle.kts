import org.jetbrains.intellij.platform.gradle.IntelliJPlatformType
import org.jetbrains.intellij.platform.gradle.tasks.PatchPluginXmlTask

group = "org.drexa1"
version = project.findProperty("version") ?: "1.0.0"

plugins {
    kotlin("jvm") version "2.2.0"
    id("org.jetbrains.intellij.platform") version "2.7.2"
    id("org.jetbrains.grammarkit") version "2022.3.2.2"
}

repositories {
    mavenCentral()
    intellijPlatform {
        snapshots()
        defaultRepositories()
    }
}

sourceSets["main"].java {
    srcDir("build/generated-src/jflex")
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


tasks.register("generateGedcomLexer", org.jetbrains.grammarkit.tasks.GenerateLexerTask::class.java) {
    sourceFile.set(file("src/main/jflex/org/drexa1/gedcom/GedcomLexer.flex"))
    targetOutputDir.set(file("build/generated-src/jflex/org/drexa1/gedcom"))
}