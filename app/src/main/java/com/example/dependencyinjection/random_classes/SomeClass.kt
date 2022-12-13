package com.example.dependencyinjection.random_classes

import com.example.dependencyinjection.interface_implementation.SomeInterfaceImpl
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class SomeClass @Inject
constructor(private val someOtherClass: SomeOtherClass,
            private val someInterfaceImpl: SomeInterfaceImpl)
{
    fun doAThing():String{
        return "Look I did something!"
    }
    fun doSomeOtherThing():String{
        return someOtherClass.doSomeOtherThings()
    }
    fun doAThingByInterface():String{
        return "Look I got ${someInterfaceImpl.getAThing()}"
    }
}