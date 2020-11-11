package com.androdude.pizzaorderapp.UI.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.androdude.pizzaorderapp.DATA.Repository
import com.androdude.pizzaorderapp.R
import com.androdude.pizzaorderapp.Resources
import com.androdude.pizzaorderapp.UI.ViewModel.MainViewModel
import com.androdude.pizzaorderapp.UI.ViewModel.MainViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var mainViewModelFactory: MainViewModelFactory
    private val repository = Repository()
    lateinit var mainViewModel : MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.newNavHostFragment) as NavHostFragment
        val navController = navHostFragment.navController
        mainViewModelFactory = MainViewModelFactory(repository)
        mainViewModel = ViewModelProvider(this,mainViewModelFactory).get(MainViewModel::class.java)
        mainViewModel.getAllFoodTypes()
        mainViewModel.getAllPizzas()

        Log.i("MAIN","ONCREATED")

    }

    override fun onResume() {
        super.onResume()
        Log.i("MAIN","ONRESUMED")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("MAIN","ONDESTROYED")
    }
}