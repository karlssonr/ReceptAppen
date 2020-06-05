package com.example.receptappen

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class AdapterChoosenCategory(private val context: Context,
                             private val listOfRecipes: List<Recipe>,
                             private val vegitarianRecipes: List<Recipe>,
                             private val meatRecipes: List<Recipe>,
                             private val chickenRecipes: List<Recipe>,
                             private val fishRecipes: List<Recipe>,
                             private val dessertRecipes: List<Recipe>,
                             private val choosenCategoryFragment: ChoosenCategoryFragment): RecyclerView.Adapter<AdapterChoosenCategory.CustomViewHolder>() {


    private val layoutInflator = LayoutInflater.from(context)

    override fun getItemCount(): Int {

        return 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {

        val itemView = layoutInflator.inflate(R.layout.choosen_category_row, parent, false)




        return CustomViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {


        val meatCategory = choosenCategoryFragment.arguments?.getString("meat")

        println(meatCategory)





    }





    inner class CustomViewHolder(val view: View): RecyclerView.ViewHolder(view) {



    }
}
