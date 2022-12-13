package com.example.dependencyinjection

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentFactory
import com.example.dependencyinjection.random_classes.SomeClass
import com.example.dependencyinjection.test_demo.*
import com.example.dependencyinjection.ui.LoginFragment
import com.example.dependencyinjection.ui.MainFragmentFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity(){

    //THESE ARE FIELD INJECTION
  /*  @Inject
    lateinit var car: Car
    @Inject
    lateinit var someClass: SomeClass*/
    @Inject
    lateinit var fragmentFactory: MainFragmentFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /*car.getCar()
        println(someClass.doAThing())
        println(someClass.doSomeOtherThing())
        println(someClass.doAThingByInterface())
        println(someClass.doAThingByInterface2())*/

        supportFragmentManager.fragmentFactory = fragmentFactory
        supportFragmentManager.beginTransaction().replace(R.id.main_fragment_container,
            LoginFragment::class.java,null).commit()
    }

}











