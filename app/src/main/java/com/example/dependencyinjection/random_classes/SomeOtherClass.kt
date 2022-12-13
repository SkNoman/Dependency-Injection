package com.example.dependencyinjection.random_classes

import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class SomeOtherClass @Inject constructor(){
    fun doSomeOtherThings():String{
        return "Look i did some other thing!"
    }
}