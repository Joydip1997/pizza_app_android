package com.androdude.pizzaorderapp.UI.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.androdude.pizzaorderapp.DATA.Model.FavPizzaModel.FavPizzaModel
import com.androdude.pizzaorderapp.DATA.Model.FoodTypeModel.FoodTypeModel
import com.androdude.pizzaorderapp.DATA.Model.PizzaDetails.AllPizzaDetails
import com.androdude.pizzaorderapp.DATA.Repository
import com.androdude.pizzaorderapp.Model.PizzaDetailsModel
import com.androdude.pizzaorderapp.Resources
import kotlinx.coroutines.launch
import kotlinx.coroutines.withTimeoutOrNull
import retrofit2.Response

class MainViewModel(val repository: Repository) :ViewModel() {



    val foodTypeLiveData : MutableLiveData<Resources<FoodTypeModel>> = MutableLiveData()
    val allPizzasLiveData : MutableLiveData<Resources<AllPizzaDetails>> = MutableLiveData()




    fun getAllFoodTypes()
    {
        var response : Response<FoodTypeModel>
        viewModelScope.launch {
            foodTypeLiveData.postValue(Resources.Loading())
            val job  = withTimeoutOrNull(1500,{
                response = repository.getAllFoodTypes()
                foodTypeLiveData.postValue(isItProperResponse(response))
            })
            if(job==null)
            {
                foodTypeLiveData.postValue(Resources.Error("Server Fucked up :("))
            }


        }
    }

    fun getAllPizzas()
    {
        var response : Response<AllPizzaDetails>
        viewModelScope.launch {
            allPizzasLiveData.postValue(Resources.Loading())
            val job  = withTimeoutOrNull(1500,{
                response = repository.getAllPizzas()
                allPizzasLiveData.postValue(isItProperResponse(response))
            })
            if(job==null)
            {
                allPizzasLiveData.postValue(Resources.Error("Server Fucked up :("))
            }


        }
    }

    fun<T> isItProperResponse(response: Response<T>) : Resources<T>
    {
        if(response.isSuccessful)
        {
            response.body()?.let {
                return Resources.Success(it)
            }
        }
        return Resources.Error(response.message())
    }
}