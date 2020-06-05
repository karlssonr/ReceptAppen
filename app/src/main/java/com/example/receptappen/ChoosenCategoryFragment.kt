package com.example.receptappen

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.OrientationHelper
import androidx.recyclerview.widget.RecyclerView


class ChoosenCategoryFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_choosen_category, container, false)
        val activity = activity as Context

        val category = arguments?.getString("category")

        val choosenCatagoryRecyclerview = view.findViewById<RecyclerView>(R.id.recyclerview_choosen_category)

        println("!!!" + category)




        choosenCatagoryRecyclerview.layoutManager = LinearLayoutManager(activity, OrientationHelper.HORIZONTAL, false)
        choosenCatagoryRecyclerview.adapter = AdapterChoosenCategory(activity,
            DataStorage.listOfRecipes,
            DataStorage.vegitarianRecipes,
            DataStorage.meatRecipes,
            DataStorage.chickenRecipes,
            DataStorage.fishRecipes,
            DataStorage.dessertRecipes,
            this)

        return view
    }

    companion object {

            fun newInstance() = ChoosenCategoryFragment()


    }
}