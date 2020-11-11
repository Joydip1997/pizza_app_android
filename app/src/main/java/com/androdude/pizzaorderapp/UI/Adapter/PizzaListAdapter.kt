package com.androdude.pizzaorderapp.UI.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.androdude.pizzaorderapp.DATA.Model.PizzaDetails.AllPizzaDetailsItem
import com.androdude.pizzaorderapp.Model.PizzaDetailsModel
import com.androdude.pizzaorderapp.R
import com.androdude.pizzaorderapp.UI.BaseAdapter
import com.androdude.pizzaorderapp.UI.GenericViewHolder
import kotlinx.android.synthetic.main.fragment_home.view.*

class PizzaListAdapter : BaseAdapter<AllPizzaDetailsItem>() {

    //private lateinit var mListener : onRecyclerViewListItemClickListener



    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): GenericViewHolder<AllPizzaDetailsItem> {
        return PizzaDetailsViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.pizza_item_layout,parent,false))
    }

    inner class PizzaDetailsViewHolder(itemView: View):GenericViewHolder<AllPizzaDetailsItem>(itemView)
    {
        private val pizzaNameTextView = itemView.findViewById<TextView>(R.id.pizza_item_nameView)
        private val pizzaTypeView = itemView.findViewById<TextView>(R.id.pizza_item_typeView)
        private val pizzaPriceView = itemView.findViewById<TextView>(R.id.pizza_item_priceView)
        override fun onBind(item: AllPizzaDetailsItem) {
            pizzaNameTextView.text = item.name
            pizzaTypeView.text = if (item.type)"Non-Veg" else "veg"
            pizzaPriceView.text = item.newprice.toString()
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

