package com.example.dependencyinjection.test_demo

import android.util.Log
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Singleton


interface One{
    fun getName(name: String)
}

//THIS CLASS DEPENDENCY PROVIDED
class ImplementOne @Inject constructor() : One{
    //THIS CLASS BASICALLY IMPLEMENT THE INTERFACE
    //IN THIS CLASS WE OVERRIDE THE METHOD FROM INTERFACE
    override fun getName(name: String) {
        Log.d("nlog", "Car name is Audi")
        Log.d("Name",name)
    }



}
//THIS CLASS DEPENDENCY PROVIDED
class Main @Inject constructor(private val one: One){
    fun getName(){
        one.getName("Abdullah")
    }
}


//TO PROVIDE DEPENDENCY IN INTERFACE WE NEED TO CREATE A MODULE FOR THAT
@Module
//WE CAN USE THIS MODULE ANYWHERE IN THIS APPLICATION
@InstallIn(SingletonComponent::class)
abstract class AppModule{
    @Binds
    //HERE, SINGLETON IS A SCOPE
    @Singleton
    abstract fun binding(
        implementOne: ImplementOne
    ):One
}

