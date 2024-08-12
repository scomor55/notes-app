// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    // If you need to define versions here, you can do it using extra properties
    extra["compose_version"] = "1.0.2"

    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath("com.android.tools.build:gradle:8.0.2") // Updated version
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.0") // Updated version
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.38.1") // Updated version
    }
}

tasks.register<Delete>("clean") {
    delete(rootProject.buildDir)
}
plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.jetbrainsKotlinAndroid) apply false
}