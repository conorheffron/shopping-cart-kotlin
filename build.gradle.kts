group = "org.example.cart"
version = "1.0.0-RELEASE"

plugins {
    id("org.springframework.boot") version "3.2.0"
    id("io.spring.dependency-management") version "1.1.3"
    kotlin("jvm") version "1.9.10"
    kotlin("plugin.spring") version "1.9.10"
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    testImplementation("org.mockito:mockito-core:5.5.0") // For mocking
}

tasks.test {
    useJUnitPlatform()
    // Configure test logging
    testLogging {
        // Show events for passed, failed, and skipped tests
        events("passed", "failed", "skipped")

        // Show the standard output and error streams in the console
        showStandardStreams = true

        // Customize the logging format
        exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL

        // Show test results in real-time
        showCauses = true
        showExceptions = true
        showStackTraces = true
    }
}

application {
    mainClass.set("com.example.cart.ShoppingCartApplication")
}
