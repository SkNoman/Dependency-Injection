package com.example.dependencyinjection.test_demo

import android.util.Log
import javax.inject.Inject

class ImplementInterface @Inject constructor():One{
    override fun getName(name: String) {
        Log.d("imp",name)
    }
}