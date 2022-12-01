package com.example.dependencyinjection.test_demo

import android.util.Log
import javax.inject.Inject


class Engine @Inject constructor() {
    fun getEngine(){
        Log.d("nlog", "Engine is started")
    }
}