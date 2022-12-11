package com.example.dependencyinjection.test_demo
import javax.inject.Inject

class Name @Inject constructor(private val one:One){
    fun getName(){
        one.getName("Exclusive")
    }
}