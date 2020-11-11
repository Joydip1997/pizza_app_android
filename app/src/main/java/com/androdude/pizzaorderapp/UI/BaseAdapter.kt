package com.androdude.pizzaorderapp.UI

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import java.lang.reflect.GenericArrayType

open class BaseAdapter<T> : RecyclerView.Adapter<GenericViewHolder<T>>() {

    lateinit var itemList: ArrayList<T>
    var onItemClickListener : ((T) -> Unit)?=null


    fun addItems(items: ArrayList<T>) {
        this.itemList = items
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenericViewHolder<T> {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(viewType,parent,false)
        return GenericViewHolder(view)
    }

    override fun onBindViewHolder(holder: GenericViewHolder<T>, position: Int) {
        holder.onBind(itemList[position])
        holder.apply {
        }
    }

    override fun getItemCount() = itemList.size




}


open class GenericViewHolder<T>(itemView: View):RecyclerView.ViewHolder(itemView),BindRecyclerViewHolder<T>
{
    override fun onBind(item: T) {

    }



}

interface BindRecyclerViewHolder<T>
{
    fun onBind(item : T)
}

