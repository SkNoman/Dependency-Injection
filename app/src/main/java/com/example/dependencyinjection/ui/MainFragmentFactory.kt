package com.example.dependencyinjection.ui

import androidx.fragment.app.FragmentFactory
import com.example.dependencyinjection.random_classes.SomeClass
import com.example.dependencyinjection.random_classes.SomeOtherClass
import javax.inject.Inject

class MainFragmentFactory
@Inject constructor(private val someString: String,
                    private val someClass: SomeClass,
                    private val someOtherClass: SomeOtherClass) : FragmentFactory() {

    override fun instantiate(
        classLoader: ClassLoader,
        className: String
    ): androidx.fragment.app.Fragment {
        return when(className){
            LoginFragment::class.java.name ->{
                LoginFragment(someString,someClass,someOtherClass)
            }
           /* SignUpFragment::class.java.name ->{
                SignUpFragment(someClass)
            }*/
            else -> super.instantiate(classLoader, className)
        }
    }
}