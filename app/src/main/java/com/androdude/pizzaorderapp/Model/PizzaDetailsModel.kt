package com.androdude.pizzaorderapp.Model

import java.io.Serializable

data class PizzaDetailsModel(val id : String,val name : String, val type : Boolean, val  price : Float):
    Serializable