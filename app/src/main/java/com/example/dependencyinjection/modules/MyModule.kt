package com.example.dependencyinjection.modules

import com.example.dependencyinjection.interface_implementation.SomeInterfaceImpl
import com.example.dependencyinjection.interfaces.SomeInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class MyModule{

    @Singleton
    @Provides
    fun provideSomeString():String{
        return "Some String!"
    }
    @Singleton
    @Provides
    fun provideSomeInterface(someString: String): SomeInterface {
        return SomeInterfaceImpl(someString)
    }
}