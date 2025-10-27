group = "org.example.cart"
version = "1.0.4-RELEASE"

plugins {
    kotlin("jvm") version "2.2.20"
    id("org.springframework.boot") version "3.5.6"
    id("io.spring.dependency-management") version "1.1.7"
    kotlin("plugin.spring") version "2.2.21"
    application
    id("org.jetbrains.kotlinx.kover") version "0.9.3"
    id("jacoco") // Apply the JaCoCo plugin
    id("org.sonarqube") version "6.3.1.5724"
}

sonar {
    properties {
        property("sonar.projectKey", "conorheffron_shopping-cart-kotlin")
        property("sonar.organization", "conorheffron")
    }
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
    testImplementation("org.mockito:mockito-core:5.20.0") // For mocking
}

tasks.test {
    useJUnitPlatform()
    finalizedBy(tasks.jacocoTestReport)
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

jacoco {
    toolVersion = "0.8.10" // Specify the JaCoCo version
}

tasks.jacocoTestReport {
    dependsOn(tasks.test) // Ensure tests run before generating the report

    reports {
        xml.required.set(true) // Generate XML report (useful for CI tools)
        html.required.set(true) // Generate HTML report for local viewing
        csv.required.set(false) // Disable CSV report (optional)
    }
}

tasks.jacocoTestCoverageVerification {
    dependsOn(tasks.jacocoTestReport) // Ensure the report is available

    violationRules {
        rule {
            limit {
                minimum = 0.8.toBigDecimal() // Set minimum coverage to 80%
            }
        }
    }
}

application {
    mainClass.set("org.example.cart.ShoppingCartApplicationKt")
}
