package com.example.dependencyinjection

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dependencyinjection.random_classes.SomeClass
import com.example.dependencyinjection.test_demo.*
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity @Inject constructor(): AppCompatActivity(){

    //THESE ARE FIELD INJECTION
    @Inject
    lateinit var car: Car
    @Inject
    lateinit var someClass: SomeClass

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        car.getCar()
        println(someClass.doAThing())
        println(someClass.doSomeOtherThing())
        println(someClass.doAThingByInterface())
    }

}











