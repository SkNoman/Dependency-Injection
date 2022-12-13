package com.example.dependencyinjection.ui

import androidx.fragment.app.Fragment
import com.example.dependencyinjection.R
import com.example.dependencyinjection.random_classes.SomeClass
import javax.inject.Inject

class SignUpFragment @Inject constructor(private val someClass: SomeClass):
    Fragment(R.layout.layout_sign_up_fragment) {

}