package com.example.dependencyinjection.test_demo

import android.util.Log
import javax.inject.Inject

class Wheel @Inject constructor() {
    fun getWheel(){
        Log.d("nlog", "Wheel is rotating")
    }
}