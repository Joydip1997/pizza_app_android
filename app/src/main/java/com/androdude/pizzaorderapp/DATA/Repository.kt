package com.androdude.pizzaorderapp.DATA

import com.androdude.pizzaorderapp.DATA.Api.RetrofitInstance

class Repository {
   suspend fun getAllFoodTypes() = RetrofitInstance.api.getAllFoodTypeList()
   suspend fun getAllPizzas() = RetrofitInstance.api.getAllPizzas()
}