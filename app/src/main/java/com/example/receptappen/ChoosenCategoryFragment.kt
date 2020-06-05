package com.example.receptappen

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


class ChoosenCategoryFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_choosen_category, container, false)
        val activity = activity as Context

        val meatCategory = arguments?.getString("meatCategory")

        println("!!!" + meatCategory)


        return view
    }

    companion object {

            fun newInstance() = ChoosenCategoryFragment()


    }
}