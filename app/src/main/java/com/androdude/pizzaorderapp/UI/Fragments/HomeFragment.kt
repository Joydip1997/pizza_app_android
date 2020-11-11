package com.androdude.pizzaorderapp.UI.Fragments

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.androdude.pizzaorderapp.DATA.Model.FavPizzaModel.FavPizzaModel
import com.androdude.pizzaorderapp.DATA.Model.FoodTypeModel.FoodTypeModel
import com.androdude.pizzaorderapp.DATA.Model.PizzaDetails.AllPizzaDetails
import com.androdude.pizzaorderapp.DATA.Model.PizzaDetails.AllPizzaDetailsItem
import com.androdude.pizzaorderapp.Model.PizzaDetailsModel
import com.androdude.pizzaorderapp.Model.TypeOfFood
import com.androdude.pizzaorderapp.R
import com.androdude.pizzaorderapp.Resources
import com.androdude.pizzaorderapp.UI.Activities.MainActivity
import com.androdude.pizzaorderapp.UI.Adapter.FoodTypeAdapter
import com.androdude.pizzaorderapp.UI.Adapter.PizzaListAdapter
import com.androdude.pizzaorderapp.UI.BaseFragment
import com.androdude.pizzaorderapp.UI.ViewModel.MainViewModel
import com.androdude.pizzaorderapp.databinding.FragmentHomeBinding

class HomeFragment : BaseFragment<MainViewModel,FragmentHomeBinding>() {
    private val pizzaList by lazy {
        ArrayList<AllPizzaDetailsItem>()
    }
    private val foodTypeList by lazy {
        ArrayList<TypeOfFood>()
    }
    private val pizzaListAdapter by lazy {
        PizzaListAdapter()
    }
    private val foodTypeAdapter by lazy {
        FoodTypeAdapter()
    }




    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = (activity as MainActivity).mainViewModel
        viewModel!!.allPizzasLiveData.observe(viewLifecycleOwner, Observer { resources->
            when(resources)
            {
                is Resources.Loading -> {

                }

                is Resources.Success -> {
                    resources.data?.let {pizzas->

                        setAllPizzas(pizzas)
                    }

                }

                is Resources.Error -> {

                }
            }
        })
        viewModel!!.foodTypeLiveData.observe(viewLifecycleOwner, Observer { resources->
            when(resources)
            {
                is Resources.Loading -> {
                    Log.i("DATA","Loading")
                }

                is Resources.Success -> {
                    resources.data?.let {foodTypes->
                        Log.i("DATA",foodTypes.size.toString())
                        setFoodTypes(foodTypes)
                    }

                }

                is Resources.Error -> {
                    Log.i("DATA",resources.message.toString())
                }
            }
        })


    }

    private fun setAllPizzas(pizzas: AllPizzaDetails) {
        pizzaList.clear()
        pizzas.forEach()
        {
            if(it.fav)
            {
                pizzaList.add(
                    it
                )
            }

        }

        pizzaListAdapter.apply {
            addItems(pizzaList)
            onItemClickListener={
                val bundle = Bundle()
                bundle.putSerializable("PizzaItem",it)
                findNavController().navigate(R.id.action_homeFragment_to_pizzaFragment,bundle)
                Toast.makeText(context,it.size.toString(),Toast.LENGTH_SHORT).show()
            }
        }
        binding.pizzaListRecyclerView.apply {
            adapter=pizzaListAdapter
            layoutManager=LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        }
    }

    private fun setFoodTypes(foodTypes: FoodTypeModel) {
        foodTypeList.apply {
            clear()
            foodTypes.forEach()
            {
                foodTypeList.add(TypeOfFood(it._id,it.name,it.type))
            }
        }
        foodTypeAdapter.addItems(foodTypeList)
        binding.foodTypeRecyclerView.apply {
            adapter=foodTypeAdapter
            layoutManager=LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        }
    }



    override fun getFragmentView() = R.layout.fragment_home
    override fun getViewModel() = MainViewModel::class.java

}