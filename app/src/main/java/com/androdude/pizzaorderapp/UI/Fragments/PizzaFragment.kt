package com.androdude.pizzaorderapp.UI.Fragments

import android.icu.number.IntegerWidth
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.androdude.pizzaorderapp.Constants.CHEESE_PRICE
import com.androdude.pizzaorderapp.Constants.GARLIC_PRICE
import com.androdude.pizzaorderapp.Constants.SAUCE_PRICE
import com.androdude.pizzaorderapp.R
import com.androdude.pizzaorderapp.UI.Activities.MainActivity
import com.androdude.pizzaorderapp.UI.BaseFragment
import com.androdude.pizzaorderapp.UI.ViewModel.MainViewModel
import com.androdude.pizzaorderapp.databinding.FragmentPizzaItemBinding

class PizzaFragment : BaseFragment<MainViewModel,FragmentPizzaItemBinding>() {

    val dataArgs : PizzaFragmentArgs by navArgs()
    var extraPriceCount : MutableLiveData<Int> = MutableLiveData(0)
    var extraCheesePriceCount : MutableLiveData<Int> = MutableLiveData(0)
    var extraGarlicPriceCount : MutableLiveData<Int> = MutableLiveData(0)
    var extraSaucePriceCount : MutableLiveData<Int> = MutableLiveData(0)
    var extraCheeseCount:  MutableLiveData<Int> = MutableLiveData(1)
    var extraGarlicCount :  MutableLiveData<Int> = MutableLiveData(0)
    var extraSauceCount  :  MutableLiveData<Int> = MutableLiveData(0)
    private val priceLiveData :  MutableLiveData<Int> = MutableLiveData(0)
    private var pizzaBasePrice = 0
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.pizzaName.setText(dataArgs.PizzaItem.name)
        binding.pizzaType.setText(setType())
        priceLiveData.postValue(dataArgs.PizzaItem.newprice)
        pizzaBasePrice = dataArgs.PizzaItem.newprice


      






    }



    private fun setType(): String? {


        return when(dataArgs.PizzaItem.size)
        {
            1 -> "Small"
            2 -> "Medium"
            3 -> "Large"
            else -> null
        }
    }




    override fun getFragmentView() = R.layout.fragment_pizza_item
    override fun getViewModel() = MainViewModel::class.java
}