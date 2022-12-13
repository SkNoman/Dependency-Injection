package com.example.dependencyinjection.random_classes

import com.example.dependencyinjection.interface_implementation.SomeInterfaceImpl
import com.example.dependencyinjection.interface_implementation.SomeInterfaceImpl2
import com.example.dependencyinjection.interfaces.SomeInterface
import com.example.dependencyinjection.modules.Impl1
import com.example.dependencyinjection.modules.Impl2
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class SomeClass @Inject
constructor(private val someOtherClass: SomeOtherClass,
           @Impl1 private val someInterfaceImpl: SomeInterface,
            @Impl2 private val someInterfaceImpl2: SomeInterface)
{
    val name = "Jon Doe"
    val age = 24
    val gender = "Male"
    fun doAThing():String{
        return "Look I did something!"
    }
    fun doSomeOtherThing():String{
        return someOtherClass.doSomeOtherThings()
    }
    fun doAThingByInterface():String{
        return "Look I got ${someInterfaceImpl.getAThing()}"
    }
    fun doAThingByInterface2():String{
        return "Look I got ${someInterfaceImpl2.getAThing()}"
    }
}