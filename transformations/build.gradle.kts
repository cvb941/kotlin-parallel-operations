plugins {
    id("org.jetbrains.kotlin.jvm") version "1.8.0"
    id("maven-publish")
}

group = "net.kusik.library"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    testImplementation("org.jetbrains.kotlin:kotlin-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit")
    testImplementation(group= "com.carrotsearch", name= "junit-benchmarks", version= "0.7.2")

    // Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
}
