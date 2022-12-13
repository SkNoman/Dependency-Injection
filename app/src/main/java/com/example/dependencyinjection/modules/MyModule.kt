package com.example.dependencyinjection.modules

import com.example.dependencyinjection.interface_implementation.SomeInterfaceImpl
import com.example.dependencyinjection.interface_implementation.SomeInterfaceImpl2
import com.example.dependencyinjection.interfaces.SomeInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class MyModule{

    @Singleton
    @Provides
    fun provideSomeString():String{
        return "Some String By Module!"
    }
    @Impl1
    @Singleton
    @Provides
    fun provideSomeInterface(someString: String): SomeInterface {
        return SomeInterfaceImpl(someString)
    }
    @Impl2
    @Singleton
    @Provides
    fun provideSomeInterface2(someString: String):SomeInterface{
        return  SomeInterfaceImpl2(someString)
    }
}

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class Impl1

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class Impl2
