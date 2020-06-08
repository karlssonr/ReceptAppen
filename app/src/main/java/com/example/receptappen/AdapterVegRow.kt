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

class AdapterVegRow(private val context: Context, private val vegitarianRecipes: List<Recipe>, private val homeFragment: HomeFragment): RecyclerView.Adapter<AdapterVegRow.CustomViewHolder>() {



    private val layoutInflator = LayoutInflater.from(context)






    override fun getItemCount() = vegitarianRecipes.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {

        val itemView = layoutInflator.inflate(R.layout.veg_row, parent, false)
        return CustomViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {



        val recipe = vegitarianRecipes[position]

        Picasso.with(context).load(recipe.image).into(holder.vegRecipeImage)
        holder.vegRecipeCategory.text = recipe.category
        holder.vegRecipeTime.text = recipe.cookTime
        holder.vegRecipeTitle.text = recipe.title

        holder.vegRecipeCardview.setOnClickListener {

            holder.bundle.putString("vegRecipeImage" , recipe.image )
            holder.bundle.putString("vegRecipeTitle" , recipe.title )
            holder.bundle.putString("vegRecipeCategory" , recipe.category )
            holder.bundle.putString("vegRecipeTime" , recipe.cookTime )
            holder.bundle.putString("vegRecipeDescription" , recipe.description )
            holder.bundle.putString("vegRecipeIngrediens" , recipe.ingredients )

            holder.choosenRecipeFragment.arguments = holder.bundle
            homeFragment.activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.fragment_container, holder.choosenRecipeFragment)?.commit()

        }



        }




   inner class CustomViewHolder(val view: View): RecyclerView.ViewHolder(view) {

        var vegRecipeImage = view.findViewById<ImageView>(R.id.imageView_veg_row)
        var vegRecipeTitle = view.findViewById<TextView>(R.id.textView_veg_row_title)
        var vegRecipeCategory = view.findViewById<TextView>(R.id.textView_veg_row_category)
        var vegRecipeTime = view.findViewById<TextView>(R.id.textView_veg_row_time)


       val vegRecipeCardview = view.findViewById<CardView>(R.id.cardview_veg_row)


       val bundle = Bundle()
       val choosenRecipeFragment = ChoosenRecipeFragment()

    }



    }




