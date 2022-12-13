package com.example.dependencyinjection.interface_implementation

import com.example.dependencyinjection.interfaces.SomeInterface
import javax.inject.Inject

class SomeInterfaceImpl2 @Inject constructor(
    private val someDependency:String):SomeInterface
{
    override fun getAThing(): String {
        return "A Thing By Interface IMPL 2 and $someDependency"
    }
}