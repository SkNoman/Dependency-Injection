package com.example.dependencyinjection.test_demo

import android.util.Log
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Singleton


interface One{
    fun getName(name: String)
}

//THIS CLASS DEPENDENCY PROVIDED

class ImplementOne @Inject constructor(private val myName: String) : One{
    //THIS CLASS BASICALLY IMPLEMENT THE INTERFACE
    //IN THIS CLASS WE OVERRIDE THE METHOD FROM INTERFACE
    override fun getName(name: String) {
        Log.d("name","My name is $myName")
        Log.d("nlog",name)
    }



}
//THIS CLASS DEPENDENCY PROVIDED
class Main @Inject constructor(private val one: One){
    fun getName(){
        one.getName("From Main File")
    }
}

//FIRST WAY TO PROVIDE DEPENDENCY IN INTERFACE (Better way)
//TO PROVIDE DEPENDENCY IN INTERFACE WE NEED TO CREATE A MODULE FOR THAT
/*
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
*/

//SECOND WAY TO PROVIDE DEPENDENCY IN INTERFACE (In efficient way)

@Module
@InstallIn(SingletonComponent::class)
class AppModule{

    @Provides
    @Singleton
    fun getName():String = "Noman" //DEPENDENCY PROVIDED AS STRING CLASS
    @Provides
    @Singleton
    fun binding(myName: String):One = ImplementOne(myName)
}
