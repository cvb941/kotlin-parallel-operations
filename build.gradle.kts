import org.jetbrains.kotlin.gradle.targets.js.dsl.ExperimentalWasmDsl

plugins {
    kotlin("multiplatform") version "1.9.23"
    id("org.jetbrains.kotlinx.benchmark") version "0.4.10"
    id("org.jetbrains.kotlin.plugin.allopen") version "1.9.23"
    id("maven-publish")
}

group = "net.kusik"
version = "2.0.0"

repositories {
    mavenCentral()
}

kotlin {
    jvm {
        jvmToolchain(11)
        withJava()
        testRuns["test"].executionTask.configure {
            useJUnitPlatform()
        }

        compilations.create("benchmark") {
            associateWith(compilations.getByName("test"))
        }
    }
    js {
        nodejs()
        browser {
            commonWebpackConfig {
                cssSupport {
                    enabled.set(true)
                }
            }
        }
    }
    @OptIn(ExperimentalWasmDsl::class)
    wasmJs()

    linuxX64()
    linuxArm64()
    mingwX64()
    macosX64()
    macosArm64()
    iosX64()
    iosArm64()
    watchosX64()
    watchosArm32()
    watchosArm64()

    applyDefaultHierarchyTemplate()

    sourceSets {
        commonMain {
            dependencies {
                // Coroutines
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.0")
            }
        }
        commonTest {
            dependencies {
                implementation(kotlin("test"))

                // Coroutines
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.8.0")
            }
        }
        val jvmBenchmark by getting {
            dependencies {
                // Kotlinx Benchmark
                implementation("org.jetbrains.kotlinx:kotlinx-benchmark-runtime:0.4.10")
            }
        }
    }
}

benchmark {
    targets {
        register("jvmBenchmark")
//        register("js")
//        register("macosArm64")
//        register("wasm")
    }
}

// For benchmarks
allOpen {
    annotation("org.openjdk.jmh.annotations.State")
}

publishing {
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/cvb941/kotlin-parallel-operations")
            credentials {
                username = project.findProperty("gpr.user")?.toString() ?: System.getenv("GITHUB_ACTOR")
                password = project.findProperty("gpr.key")?.toString() ?: System.getenv("GITHUB_TOKEN")
            }
        }
    }
}
