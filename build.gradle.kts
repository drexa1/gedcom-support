import org.jetbrains.changelog.Changelog
import org.jetbrains.intellij.platform.gradle.IntelliJPlatformType
import org.jetbrains.intellij.platform.gradle.tasks.PatchPluginXmlTask
import org.jetbrains.intellij.platform.gradle.tasks.PublishPluginTask
import org.jetbrains.intellij.platform.gradle.tasks.SignPluginTask

group = "org.drexa1"
version = project.findProperty("version") ?: "1.0.0"

plugins {
    kotlin("jvm") version "2.2.0"
    id("org.jetbrains.intellij.platform") version "2.7.2"
    id("org.jetbrains.grammarkit") version "2022.3.2.2"
    id("org.jetbrains.changelog") version "2.2.0"
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

tasks.withType<PatchPluginXmlTask> {
    version = project.version.toString()
    changeNotes.set(provider {
        changelog.renderItem(changelog.getLatest(), Changelog.OutputType.HTML)
    })
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

tasks.named<SignPluginTask>("signPlugin") {
    keyStore.set(file("certs/plugin.jks"))
    password.set(provider { System.getenv("PLUGIN_SIGN_PASSWORD") })
}

tasks.named<PublishPluginTask>("publishPlugin") {
    token.set(System.getenv("PUBLISH_TOKEN"))
    channels.set(listOf("default"))
    dependsOn("signPlugin")
}