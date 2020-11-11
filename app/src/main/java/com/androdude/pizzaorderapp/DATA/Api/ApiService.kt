package com.androdude.pizzaorderapp.DATA.Api

import com.androdude.pizzaorderapp.DATA.Model.FavPizzaModel.FavPizzaModel
import com.androdude.pizzaorderapp.DATA.Model.FoodTypeModel.FoodTypeModel
import com.androdude.pizzaorderapp.DATA.Model.PizzaDetails.AllPizzaDetails
import retrofit2.Response
import retrofit2.http.GET


interface ApiService {

    @GET("/api/getfoodlist")
    suspend fun getAllFoodTypeList() : Response<FoodTypeModel>


    @GET("/api/getfav/pizzas")
    suspend fun getAllFavPizzas() : Response<FavPizzaModel>

    @GET("/api/getallpizzas")
    suspend fun getAllPizzas() : Response<AllPizzaDetails>


}