# AndroidAppDevelopment_Plants
This is NIT3213 Assessment 2 Android Application Development Project based on POST and GET request

APP Overview:
Consist of 3 screens:
1. Login Screen
2. Dashboard Screen
3. Details Screen

      Notes:
This application is created using Android Studio. Make sure that this application is installed in your device.

      Objective:
Develop an Android application that demonstrates proficiency in API integration, user intefacce (UI) design and Android Development best practices.

      Project Overview:
   1. Create an Android App with 3 main screens: Login, Dashboard and Details.
   2. The app will interact with the 'vu-nit3213-api' to authenticate users and retrieve data.

      API Details:
Base URL: https://nit3213-api-h2b3-latest.onrender.com

   1. Login Endpoint:
   - URL: /footscray/auth
   - Method: POST
   - Request Body:
{
  "username" : "FirstName"
  "password" : "sStudentID"
}
   - Successful Response (200 OK):
{
  "keypass": "topicName"
}

   2. Dashboard Endpoint:
   - URL: /dashboard/{keypass}
   - Method: GET
   - Successful Response (200 OK):
   {
  "entities": [
    {
      "property1": "value1",
      "property2": "value2",
      "description": "Detailed description"
    },
    // More objects...
  ],
  "entityTotal": 7
}

      Instructions:
     1. Login Screen:
             - Implement user interface for login with username and password fields
             - Use student's first name as the username and student ID (format: s1234567) as the password
             - Make a POST request to the appropriate auth endpoint based on class location
             - Handle and display appropriate error messages for unsuccessful login attempts
             - Upon successful login, navigate to Dashboard Screen.

     2. Dashboard Sceen:
      - Implement a RecyclerView to display the list of entities received from dashboard endpoint
      - Use the keypass received from the login response to make a GET request to the dashboard endpoint
      - Each item in the RecyclerView should display a summary of the entity( excluding the description )
      - Implement click funcionality (Button) on RecyclerView items to navigate to Details screen

      3. Details Screen:
      - Display all information about the selected entity, including the description
      - Implement a user-friendly layout to present the information clearly

Setup Instructions:

- Installing plugins and dependencies required for the APP Project:

   After creating new project in android studio, wait for the gradle-script to finish compiling.
      IMPORTANT STEPS:
  
      1. Under Gradle Scripts -> build.gradle.kts (Project):
         Add this under plugins: id("com.google.dagger.hilt.android") version "2.51.1" apply false // Hilt
      2. Under Gradle Scripts -> build.gradle.kts(Module: app):
      Add the following plugins and dependencies:
         Plugins:
            id("kotlin-parcelize")
            id("kotlin-kapt")
            id("com.google.dagger.hilt.android")
         Dependencies:
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

      After the big dependencies {}, add the following below the end curly bracket:

      // Allow references to generated code
      kapt {
          correctErrorTypes = true
      }

How to run the application:

1. Since this code has already have all the dependencies and injections ready, you can run the application by copy and paste the repository link to Android Studio by
   File -> New -> Project From Version Control

   A PopUp Window will open where you can paste the repository link under select repository URL from git and open it on local Android Studio Application.
   
3. Alternatively, you can download the file from the repository link as the ZIP file and once downloaded, UNZIP the ZIP file and open the gradle app from the folder on Android Studio
