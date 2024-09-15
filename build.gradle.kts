/*
 * This file was generated by the Gradle 'init' task.
 *
 * This generated file contains a sample Kotlin application project to get you started.
 * For more details take a look at the 'Building Java & JVM projects' chapter in the Gradle
 * User Manual available at https://docs.gradle.org/7.6/userguide/building_java_projects.html
 */

plugins {
    // Apply the org.jetbrains.kotlin.jvm Plugin to add support for Kotlin.
    id("org.jetbrains.kotlin.jvm") version "2.0.20"
    kotlin("plugin.serialization") version "2.0.20"

    // Apply the application plugin to add support for building a CLI application in Java.
    application
}

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
    maven("https://repo.akka.io/maven/")
}

val akkaVersion = "2.9.5"
val akkaHttpVersion = "10.6.3"
val akkaProjectionVersion = "1.5.5"
val jacksonVersion = "2.17.2"
val ktorVersion = "2.3.12"
val kotlinSerializationVersion = "1.7.2"

dependencies {
    // Akka dependencies (using Java/Kotlin-friendly APIs)
    implementation("com.typesafe.akka:akka-actor-typed_2.13:$akkaVersion")
    implementation("com.typesafe.akka:akka-stream_2.13:$akkaVersion")
    implementation("com.typesafe.akka:akka-persistence-typed_2.13:$akkaVersion")
    implementation("com.typesafe.akka:akka-cluster-sharding-typed_2.13:$akkaVersion")
    implementation("com.typesafe.akka:akka-http_2.13:$akkaHttpVersion")
    implementation("com.typesafe.akka:akka-http-jackson_2.13:$akkaHttpVersion")

    // Cassandra driver
    implementation("com.datastax.oss:java-driver-core:4.17.0")
    implementation("com.typesafe.akka:akka-persistence-cassandra_2.13:1.2.1")

    // Logging
    implementation("ch.qos.logback:logback-classic:1.5.8")

    // Akka Projection dependencies
    implementation("com.lightbend.akka:akka-projection-core_2.13:$akkaProjectionVersion")
    implementation("com.lightbend.akka:akka-projection-eventsourced_2.13:$akkaProjectionVersion")
    implementation("com.lightbend.akka:akka-projection-cassandra_2.13:$akkaProjectionVersion")

    // Use the Kotlin JUnit 5 integration.
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")

    // Use the JUnit 5 integration.
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.9.1")

    // Add coroutines dependencies
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.9.0")

    // Ktor dependencies
    implementation("io.ktor:ktor-server-core-jvm:$ktorVersion")
    implementation("io.ktor:ktor-server-netty-jvm:$ktorVersion")
    implementation("io.ktor:ktor-server-content-negotiation-jvm:$ktorVersion")
    implementation("io.ktor:ktor-serialization-kotlinx-json-jvm:$ktorVersion")

    // Kotlin Serialization
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:$kotlinSerializationVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json-jvm:$kotlinSerializationVersion")
}

application {
    // Define the main class for the application.
    mainClass.set("com.martishin.cqrsexample.ApplicationKt")
}

tasks.named<Test>("test") {
    // Use JUnit Platform for unit tests.
    useJUnitPlatform()
}
