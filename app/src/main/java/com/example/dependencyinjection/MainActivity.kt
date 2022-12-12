package com.example.dependencyinjection

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.example.dependencyinjection.test_demo.*
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.scopes.ActivityScoped
import dagger.hilt.android.scopes.FragmentScoped
import dagger.hilt.components.SingletonComponent
import dagger.hilt.internal.processedrootsentinel.ProcessedRootSentinel
import javax.inject.Inject
import javax.inject.Singleton

@AndroidEntryPoint
class MainActivity @Inject constructor(): AppCompatActivity(),One{


    //THESE ARE FILED INJECTION
    @Inject
    lateinit var car: Car
    @Inject
    lateinit var main: Main
    @Inject
    lateinit var name: Name
    @Inject
    lateinit var implementInterface: ImplementInterface
    @Inject
    lateinit var someClass: SomeClass
    @Inject
    lateinit var someInterfaceClass: SomeInterfaceClass



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        car.getCar()
        name.getName()
        main.getName()
        val implementInterface = ImplementInterface()
        implementInterface.getName("Walton")
        println(someClass.doAThing())
        println(someClass.doSomeOtherThing())
        println(someInterfaceClass.doAThingByInterface())


       // one.getName("From Main Activity")
    }

    override fun getName(name: String) {
        Log.d("marcel",name)
    }
}
@AndroidEntryPoint
class MyFragment: Fragment(){
    @Inject
    lateinit var someClass: SomeClass
}
@ActivityScoped
class SomeClass @Inject constructor(private val someOtherClass: SomeOtherClass){
    fun doAThing():String{
        return "Look I did something!"
    }
   fun doSomeOtherThing():String{
        return someOtherClass.doSomeOtherThings()
    }
}
@ActivityScoped
class SomeOtherClass @Inject constructor(){
    fun doSomeOtherThings():String{
        return "Look i did some other thing!"
    }
}


//INTERFACE BLOCK: EXECUTE SOME INTERFACE ALONG WITH IMPLEMENTATIONS
class SomeInterfaceClass @Inject constructor(private val someInterfaceImpl: SomeInterface){
    fun doAThingByInterface():String{
        return "Look I got ${someInterfaceImpl.getAThing()}"
    }
}
class SomeInterfaceImpl @Inject constructor():SomeInterface{
    override fun getAThing(): String {
        return "A Thing By Interface!"
    }
}
interface SomeInterface{
    fun getAThing():String
}


//MODULE CLASS USING PROVIDES: THE BETTER WAY
@InstallIn(SingletonComponent::class)
@Module
class MyModule{

    /*@Singleton
    @Provides
    fun provideSomeString():String{
        return "Some String!"
    }*/

    @Singleton
    @Provides
    fun provideSomeInterface():SomeInterface{
        return SomeInterfaceImpl()
    }
}


/*//MODULE CLASS USING BINDS: THE COMPLEX WAY (AND IT DOES NOT WORK IN ALL SCENE)
@InstallIn(SingletonComponent::class)
@Module
abstract class MyModule{
    @Singleton
    @Binds
    abstract  fun bindSomeDependency(
        someImpl:SomeInterfaceImpl
    ):SomeInterface

    //IF WE TRY TO PROVIDE DEPENDENCY FOR A THIRD PARTY LIB LIKE GSON,RETROFIT
    //: THIS WILL THROW AN ERROR (AND I DON'T KNOW WHY STILL)
}*/



