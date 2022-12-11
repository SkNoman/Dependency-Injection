package com.example.dependencyinjection

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.dependencyinjection.test_demo.*
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity(),One{

    @Inject
    lateinit var car: Car
    @Inject
    lateinit var main: Main
    @Inject
    lateinit var name: Name
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        car.getCar()
        name.getName()
        main.getName()
       // one.getName("From Main Activity")
    }

    override fun getName(name: String) {

    }

}