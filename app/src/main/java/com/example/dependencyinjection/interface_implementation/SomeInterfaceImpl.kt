package com.example.dependencyinjection.interface_implementation

import com.example.dependencyinjection.interfaces.SomeInterface
import javax.inject.Inject

class SomeInterfaceImpl @Inject constructor(
    private val someDependency:String): SomeInterface
{
    override fun getAThing(): String {
        return "A Thing By Interface and $someDependency"
    }
}
