package com.androdude.pizzaorderapp.DATA.Model.PizzaDetails

import java.io.Serializable

data class AllPizzaDetailsItem(
    val __v: Int,
    val _id: String,
    val fav: Boolean,
    val imageUrl: String,
    val name: String,
    val newprice: Int,
    val oldprice: Int,
    val size: Int,
    val type: Boolean
) : Serializable