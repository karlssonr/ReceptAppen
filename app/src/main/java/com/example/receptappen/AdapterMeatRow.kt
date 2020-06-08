package com.example.receptappen

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class AdapterMeatRow(private val context: Context, private val meatRecipes : List<Recipe>, private val homeFragment: HomeFragment) : RecyclerView.Adapter<AdapterMeatRow.CustomViewHolder>() {


    private val layoutInflator = LayoutInflater.from(context)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {

        val itemView = layoutInflator.inflate(R.layout.meat_row, parent, false)
        return CustomViewHolder(itemView)

    }

    override fun getItemCount() = meatRecipes.size

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {

        val recipe = meatRecipes[position]

        println(recipe)

        Picasso.with(context).load(recipe.image).into(holder.meatRecipeImage)
        holder.meatRecipeCategory.text = recipe.category
        holder.meatRecipeTime.text = recipe.cookTime
        holder.meatRecipeTitle.text = recipe.title

        holder.meatRecipeCardview.setOnClickListener {

            holder.bundle.putString("meatRecipeImage" , recipe.image )
            holder.bundle.putString("meatRecipeTitle" , recipe.title )
            holder.bundle.putString("meatRecipeCategory" , recipe.category )
            holder.bundle.putString("meatRecipeTime" , recipe.cookTime )
            holder.bundle.putString("meatRecipeDescription" , recipe.description )
            holder.bundle.putString("meatRecipeIngrediens" , recipe.ingredients )

            holder.choosenRecipeFragment.arguments = holder.bundle
            homeFragment.activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.fragment_container, holder.choosenRecipeFragment)?.commit()

        }


    }

    inner class CustomViewHolder(val view: View): RecyclerView.ViewHolder(view) {

        var meatRecipeImage = view.findViewById<ImageView>(R.id.imageView_meat_row)
        var meatRecipeTitle = view.findViewById<TextView>(R.id.textView_meat_row_title)
        var meatRecipeCategory = view.findViewById<TextView>(R.id.textView_meat_row_category)
        var meatRecipeTime = view.findViewById<TextView>(R.id.textView_meat_row_time)

        val meatRecipeCardview = view.findViewById<CardView>(R.id.cardview_meat_row)


        val bundle = Bundle()
        val choosenRecipeFragment = ChoosenRecipeFragment()

    }

}