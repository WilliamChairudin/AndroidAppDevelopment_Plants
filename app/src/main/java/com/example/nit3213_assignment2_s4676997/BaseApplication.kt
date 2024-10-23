package com.example.nit3213_assignment2_s4676997

import android.app.Application
import android.util.Log
import dagger.hilt.android.HiltAndroidApp

//Set up base dependency injection container to the whole app
//Must set up under AndroidManifest.xml with name android:name = "nameoftheapplication"
@HiltAndroidApp
class BaseApplication: Application(){
}