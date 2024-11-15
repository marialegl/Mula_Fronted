plugins {
    id("com.androidApplication") version "8.5.2" apply false
    id("org.jetbrains.kotlinAndroid") version "2.0.21" apply false
    id("androidx.compose.compiler") version "2.0.21" apply false
    id("com.google.gms.googleService") version "4.4.2" apply false
}

    android {
        namespace = "com.malejadev.lamulaappc"
        compileSdk = 34

        defaultConfig {
            applicationId = "com.malejadev.lamulaappc"
            minSdk = 23
            targetSdk = 34
            versionCode = 1
            versionName = "1.0"

            testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        }
        packaging {
            resources {
                excludes += "/META-INF/{AL2.0,LGPL2.1}"
            }

        }

        buildTypes {
            release {
                isMinifyEnabled = false
                proguardFiles(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
                )
            }
        }
        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_1_8
            targetCompatibility = JavaVersion.VERSION_1_8
        }

        kotlinOptions {
            jvmTarget = "1.8"
        }

        composeOptions {
            kotlinCompilerExtensionVersion = "1.5.1"
        }

        buildFeatures {
            viewBinding = true
            compose = true
        }
    }

    dependencies {
        implementation(project(":shared"))
        implementation(libs.compose.ui)
        implementation(libs.compose.ui.tooling.preview)
        implementation(libs.compose.material3)
        implementation(libs.androidx.activity.compose)
        debugImplementation(libs.compose.ui.tooling)
        implementation(libs.androidx.core.ktx)
        implementation(libs.androidx.appcompat)
        implementation(libs.material)
        implementation(libs.androidx.activity)
        implementation(libs.androidx.constraintlayout)
        implementation(libs.lottie) /*Animation*/
        implementation(libs.firebaseAuth)
        implementation(libs.firebase.auth.ktx) /*Authentication whit Firebase*/
        implementation(libs.firebaseDatabase) /*Database whit Firebase*/
        implementation(libs.imagePicker) /*Crop an image*/
        implementation(libs.glide) /*Load images*/
        testImplementation(libs.junit)
        androidTestImplementation(libs.androidx.junit)
        androidTestImplementation(libs.androidx.espresso.core)

    }

