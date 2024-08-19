plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

val composeVersion = "1.0.2"

android {
    compileSdk = 35
    namespace="com.example.note_app"
    defaultConfig {
        applicationId = "com.plcoding.cleanarchitecturenoteapp"
        minSdk = 30
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
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
        freeCompilerArgs += "-Xuse-ir"  // Optional, can be removed if unnecessary
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = composeVersion
    }

    packaging {
        resources {
            excludes += setOf("/META-INF/{AL2.0,LGPL2.1}")
        }
    }
}

dependencies {
    implementation("androidx.core:core-ktx:+")
    implementation("androidx.appcompat:appcompat:+")
    implementation("com.google.android.material:material:+")
    implementation("androidx.activity:activity:1.9.1")
    implementation("androidx.compose.ui:ui:$composeVersion")
    implementation("androidx.compose.material:material:$composeVersion")
    implementation("androidx.compose.ui:ui-tooling-preview:$composeVersion")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:+")
    implementation("androidx.activity:activity-compose:+")
    testImplementation("junit:junit:4.+")
    androidTestImplementation("androidx.test.ext:junit:+")
    androidTestImplementation("androidx.test.espresso:espresso-core:+")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:$composeVersion")
    debugImplementation("androidx.compose.ui:ui-tooling:$composeVersion")

    // Compose dependencies
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.4.0-beta01")
    implementation("androidx.navigation:navigation-compose:2.4.0-alpha09")
    implementation("androidx.compose.material:material-icons-extended:$composeVersion")
    implementation("androidx.hilt:hilt-navigation-compose:1.0.0-alpha03")

    // Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:+")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:+")

    // Dagger - Hilt
    implementation("com.google.dagger:hilt-android:+")
    kapt("com.google.dagger:hilt-android-compiler:+")
    implementation("androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03")
    kapt("androidx.hilt:hilt-compiler:+")

    // Room
    implementation("androidx.room:room-runtime:+")
    kapt("androidx.room:room-compiler:+")

    // Kotlin Extensions and Coroutines support for Room
    implementation("androidx.room:room-ktx:+")
}