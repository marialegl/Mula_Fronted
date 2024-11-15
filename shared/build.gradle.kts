import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
}

kotlin {
    // Configuración para Android y los targets específicos de iOS
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
        ).forEach {
            it.binaries.framework {
                baseName = "shared"
                isStatic = true
            }
        }


        sourceSets {

            val commonMain by getting {
                dependencies {
                    implementation(libs.kotlinx.coroutines.core)
                }
            }
            val commonTest by getting {
                dependencies {
                    implementation(kotlin("test"))
                }
            }
            // Fuente específica para iOS
            val iosMain by creating {
                dependsOn(commonMain)
                dependencies {
                    // Dependencias específicas de iOS
                }
            }
            val iosTest by creating {
                dependsOn(commonTest)

            }
            val iosMain by getting {
                dependsOn(commonMain)
            }
            val iosTest by getting {
                dependsOn(commonTest)
            }
        }
    }

android {
    namespace = "com.malejadev.shared"
    compileSdk = 34
    defaultConfig {
        minSdk = 24
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}