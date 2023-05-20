plugins {
    kotlin("multiplatform") version "1.8.21"
    id("org.jetbrains.kotlinx.benchmark") version "0.4.4"
}

group = "net.kusik"
version = "1.6.0"

repositories {
    mavenCentral()
}

kotlin {
    jvm {
        jvmToolchain(19)
    }
    js(IR) {
        nodejs()
        browser()
    }

    val hostOs = System.getProperty("os.name")
    val isMingwX64 = hostOs.startsWith("Windows")
    val nativeTarget = when {
        hostOs == "Mac OS X" -> macosX64("native")
        hostOs == "Linux" -> linuxX64("native")
        isMingwX64 -> mingwX64("native")
        else -> throw GradleException("Host OS is not supported in Kotlin/Native.")
    }


    sourceSets {
        val commonMain by getting {
            dependencies {
                // Coroutines
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.1")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))

                // Coroutines
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.7.1")
            }
        }
        val jvmMain by getting
        val jvmTest by getting {
            dependencies {
//                implementation("org.jetbrains.kotlin:kotlin-test-junit")
                implementation("com.carrotsearch:junit-benchmarks:0.7.2")
            }
        }
        val jsMain by getting
        val jsTest by getting
        val nativeMain by getting
        val nativeTest by getting

        val benchmarks by creating {
            dependsOn(commonMain)

            dependencies {
                // Coroutines
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.7.1")

                // Benchmark
                implementation("org.jetbrains.kotlinx:kotlinx-benchmark-runtime:0.4.4")
            }
        }
    }
}

benchmark {
    targets {
        register("benchmark")
    }
    configurations {
        getByName("main") {

        }
    }
}
