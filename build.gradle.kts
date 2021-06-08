import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.32"
}

group = "ui.automation.kotlin"
version = "0.0.1-SNAPSHOT"

java.sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
    mavenLocal()
    mavenCentral()
}

dependencies {
    implementation("io.github.bonigarcia:webdrivermanager:4.4.3")
    implementation("org.seleniumhq.selenium:selenium-java:3.141.59")

    implementation("org.junit.jupiter:junit-jupiter-engine:5.7.2")
    implementation("org.junit.platform:junit-platform-launcher:1.7.2")
    implementation("org.junit.jupiter:junit-jupiter-params:5.7.2")

    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.10.2")
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:2.9.2")
}

tasks.withType<Test> {
    //https://docs.gradle.org/current/javadoc/org/gradle/api/tasks/testing/junitplatform/JUnitPlatformOptions.html
    useJUnitPlatform()
    testLogging.showStandardStreams = true
    //Enabling Automatic Extension Detection
    systemProperties["junit.jupiter.extensions.autodetection.enabled"] = true
}

tasks.register<Test>("regressionTest") {
    useJUnitPlatform() {
        includeTags("regression")
        excludeTags("wip")
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "1.8"
    }
}