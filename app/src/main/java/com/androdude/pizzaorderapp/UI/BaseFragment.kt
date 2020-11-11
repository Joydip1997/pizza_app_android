package com.androdude.pizzaorderapp.UI

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.androdude.pizzaorderapp.UI.ViewModel.MainViewModel


abstract class BaseFragment<VM : MainViewModel,VB : ViewBinding> : Fragment() {
    protected lateinit  var binding : VB
    protected var viewModel : VM ?= null

    private fun init(inflater: LayoutInflater, container: ViewGroup?) {
        binding = DataBindingUtil.inflate(inflater, getFragmentView(), container, false)
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        init(inflater, container)
        return binding.root
    }

    abstract fun getFragmentView() : Int
    abstract fun getViewModel() : Class<VM>


}