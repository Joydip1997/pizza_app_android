package com.androdude.pizzaorderapp.UI.Adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.androdude.pizzaorderapp.Model.PizzaDetailsModel
import com.androdude.pizzaorderapp.Model.TypeOfFood
import com.androdude.pizzaorderapp.R
import com.androdude.pizzaorderapp.UI.BaseAdapter
import com.androdude.pizzaorderapp.UI.GenericViewHolder

class FoodTypeAdapter : BaseAdapter<TypeOfFood>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): GenericViewHolder<TypeOfFood> {
        return PizzaTypeViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.food_list_item_layout,parent,false))
    }

    inner class PizzaTypeViewHolder(itemView: View): GenericViewHolder<TypeOfFood>(itemView)
    {
        private val foodTypeView = itemView.findViewById<TextView>(R.id.food_list_item_name)
        override fun onBind(item: TypeOfFood) {
            foodTypeView.text = item.name

        }
        init {
            itemView.setOnClickListener{
                if(adapterPosition != RecyclerView.NO_POSITION)
                {
                    onItemClickListener?.invoke(itemList[adapterPosition])

                }
            }
        }



    }

}