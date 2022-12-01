package com.example.dependencyinjection.test_demo

import android.util.Log
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Singleton

interface One{
    fun getName()
}
class ImplementOne @Inject constructor() : One{
    override fun getName() {
        Log.d("nlog", "Car name is Audi")
    }

}
class Main @Inject constructor(private val one: One){
    fun getName(){
        one.getName()
    }
}
@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule{
    @Binds
    @Singleton
    abstract fun binding(
        implementOne: ImplementOne
    ):One
}