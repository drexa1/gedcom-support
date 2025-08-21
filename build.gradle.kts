import org.jetbrains.intellij.platform.gradle.IntelliJPlatformType
import org.jetbrains.intellij.platform.gradle.tasks.PatchPluginXmlTask

group = "org.drexa1"
version = project.findProperty("version") ?: "1.0.0"

plugins {
    kotlin("jvm") version "2.2.0"
    id("org.jetbrains.intellij.platform") version "2.7.2"
    id("org.jetbrains.grammarkit") version "2022.3.2.2"
    id("org.jetbrains.changelog") version "2.2.0"
    id("com.diffplug.spotless") version "6.24.0"
}

repositories {
    mavenCentral()
    intellijPlatform {
        snapshots()
        defaultRepositories()
    }
}

sourceSets {
    main {
        java { srcDirs("src/main/java", "src/main/generated") }
        kotlin { srcDirs("src/main/kotlin") }
        resources { srcDirs("src/main/resources") }
    }
    test {
        kotlin { srcDirs("src/test/kotlin") }
        resources { srcDirs("src/test/resources") }
    }
}

val platform = IntelliJPlatformType.IntellijIdeaUltimate
val platformVersion = providers.gradleProperty("platformVersion")

dependencies {
    implementation(kotlin("stdlib"))
    implementation("org.antlr:antlr4-runtime:+")
    implementation("org.antlr:antlr4-intellij-adaptor:+")
    intellijPlatform {
        create(platform, platformVersion) {
            useInstaller = true
        }
        pluginVerifier()
        zipSigner()
    }
    testImplementation(kotlin("test"))
}

spotless {
    kotlin { targetExclude("src/main/generated/**") }
}

tasks.withType<PatchPluginXmlTask> {
    version = project.version.toString()
}

changelog {
    val projectVersion = project.version as String
    version.set(projectVersion)
    header.set("[$projectVersion] - ${org.jetbrains.changelog.date()}")
    groups.set(listOf("Added", "Changed", "Removed", "Fixed"))
}

tasks {
    generateLexer {
        sourceFile.set(file("src/main/grammars/gedcom.flex"))
        targetOutputDir.set(file("src/main/generated/org/drexa1/gedcom/highlighter"))
        targetFile("GedcomLexer")
        purgeOldFiles.set(true)
    }
    compileKotlin {
        dependsOn(generateLexer)
    }
    compileJava {
        dependsOn(generateLexer)
    }
    processResources {
        duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    }
    processTestResources {
        duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    }
}




