plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("kotlin-parcelize")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")

}

android {
    namespace = "com.example.nit3213_assignment2_s4676997"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.nit3213_assignment2_s4676997"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

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
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        viewBinding = true
        dataBinding = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    implementation(libs.androidx.annotation)
    implementation(libs.androidx.lifecycle.livedata.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // Retrofit dependancies
    implementation("com.squareup.retrofit2:retrofit:2.11.0")
    implementation("com.squareup.retrofit2:converter-moshi:2.11.0")
    implementation("com.squareup.moshi:moshi-kotlin:1.14.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.10.0")
    implementation("com.squareup.retrofit2:converter-gson:2.11.0")
    implementation("androidx.recyclerview:recyclerview:1.2.1")

    // Hilt dependancies
    implementation("com.google.dagger:hilt-android:2.51.1")
    kapt("com.google.dagger:hilt-android-compiler:2.51.1")

    // For network requests
    implementation ("com.squareup.okhttp3:okhttp:4.9.3")

    // For JSON parsing
    implementation ("com.squareup.moshi:moshi-kotlin:1.12.0")

    // Unit Testing
    testImplementation("io.mockk:mockk:1.13.12") // Core MockK library for local unit tests
    testImplementation("io.mockk:mockk-android:1.13.12") // Android-specific MockK for local unit tests
    testImplementation("io.mockk:mockk-agent:1.13.12") // MockK agent for advanced mocking (e.g., static methods)
    testImplementation("junit:junit:4.13.2") // JUnit for local unit tests

    // For testing UI and Android components
    testImplementation ("org.robolectric:robolectric:4.6.1")

    // Instrumented test dependencies (run on an Android device or emulator)
    androidTestImplementation("io.mockk:mockk-android:1.13.12")
    // Android- specific MockK for instrumented tests
    androidTestImplementation("io.mockk:mockk-agent:1.13.12") // MockK agent for advanced mocking in instrumented tests
    androidTestImplementation("androidx.test.ext:junit:1.1.3") // AndroidX JUnit for instrumented tests
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.4.0")

    //Coroutine Test
    testImplementation ("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.1")

    // For LiveData testing
    testImplementation ("androidx.arch.core:core-testing:2.1.0")

    //Robolectric
    testImplementation ("org.robolectric:robolectric:4.10.3")
}

// Allow references to generated code
kapt {
    correctErrorTypes = true
}