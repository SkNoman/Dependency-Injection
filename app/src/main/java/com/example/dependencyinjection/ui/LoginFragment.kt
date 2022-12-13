package com.example.dependencyinjection.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import com.example.dependencyinjection.R
import com.example.dependencyinjection.random_classes.SomeClass
import com.example.dependencyinjection.random_classes.SomeOtherClass

class LoginFragment constructor(
    private val someString: String,private val someClass: SomeClass,private val someOtherClass: SomeOtherClass)
    :Fragment(R.layout.layout_login_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("nlog","Some String From Fragment And Injected $someString")
        Log.d("nlog","Data from someClass: ${someClass.doAThing()}")
        Log.d("nlog","Data from someOtherClass: ${someOtherClass.doSomeOtherThings()}")
        Log.d("nlog","User Information:")
        Log.d("nlog","Name: ${someClass.name}, Age: ${someClass.age},Gender: ${someClass.gender}")
    }
}