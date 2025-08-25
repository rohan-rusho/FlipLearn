plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "khoda.bazar.customer"
    compileSdk = 36

    defaultConfig {
        applicationId = "khoda.bazar.customer"
        minSdk = 24
        targetSdk = 36
        versionCode = 9
        versionName = "6.0.9"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {

    dependencies {
        implementation("com.google.android.material:material:1.12.0")
        implementation(libs.appcompat)
        implementation(libs.activity)
        implementation(libs.constraintlayout)
        testImplementation(libs.junit)
        androidTestImplementation(libs.ext.junit)
        androidTestImplementation(libs.espresso.core)
    }


}