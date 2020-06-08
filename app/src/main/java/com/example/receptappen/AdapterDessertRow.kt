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

class AdapterDessertRow(private val context: Context, private val dessertRecipes : List<Recipe>, private val homeFragment: HomeFragment): RecyclerView.Adapter<AdapterDessertRow.CustomViewHolder>() {

    private val layoutInflator = LayoutInflater.from(context)

    override fun getItemCount() = dessertRecipes.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {

        val itemView = layoutInflator.inflate(R.layout.dessert_row, parent, false)
        return CustomViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {

        val recipe = dessertRecipes[position]

        Picasso.with(context).load(recipe.image).into(holder.dessertRecipeImage)
        holder.dessertRecipeCategory.text = recipe.category
        holder.dessertRecipeTime.text = recipe.cookTime
        holder.dessertRecipeTitle.text = recipe.title

        holder.dessertRecipeCardview.setOnClickListener {

            holder.bundle.putString("dessertRecipeImage" , recipe.image )
            holder.bundle.putString("dessertRecipeTitle" , recipe.title )
            holder.bundle.putString("dessertRecipeCategory" , recipe.category )
            holder.bundle.putString("dessertRecipeTime" , recipe.cookTime )
            holder.bundle.putString("dessertRecipeDescription" , recipe.description )
            holder.bundle.putString("dessertRecipeIngrediens" , recipe.ingredients )

            holder.choosenRecipeFragment.arguments = holder.bundle
            homeFragment.activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.fragment_container, holder.choosenRecipeFragment)?.commit()


        }

    }

    inner class CustomViewHolder(val view: View): RecyclerView.ViewHolder(view) {

        var dessertRecipeImage = view.findViewById<ImageView>(R.id.imageView_dessert_row)
        var dessertRecipeTitle = view.findViewById<TextView>(R.id.textView_dessert_row_title)
        var dessertRecipeCategory = view.findViewById<TextView>(R.id.textView_dessert_row_category)
        var dessertRecipeTime = view.findViewById<TextView>(R.id.textView_dessert_row_time)

        val dessertRecipeCardview = view.findViewById<CardView>(R.id.cardview_dessert_row)


        val bundle = Bundle()
        val choosenRecipeFragment = ChoosenRecipeFragment()
    }

}
