package com.example.receptappen

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.food_category_row.view.*


class AdapterFoodCategory(private val context : Context, private val homeFragment: HomeFragment,
                          private val vegitarianRecipes: List<Recipe>,
                          private val meatRecipes: List<Recipe>,
                          private val chickenRecipes: List<Recipe>,
                          private val fishRecipes: List<Recipe>,
                          private val dessertRecipes: List<Recipe>): RecyclerView.Adapter<AdapterFoodCategory.CustomViewHolderCategory>() {

    private val layoutInflator = LayoutInflater.from(context)

    val foodCategories = listOf<String>("KÖTT","VEG","FÅGEL","FISK","DESSERT")

    override fun getItemCount(): Int {
        return foodCategories.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolderCategory {

        val itemView = layoutInflator.inflate(R.layout.food_category_row, parent, false)
        return CustomViewHolderCategory(itemView)

    }

    override fun onBindViewHolder(holder: CustomViewHolderCategory, position: Int) {




        if (position == 0) {
            holder.imageViewCategory.setImageResource(R.drawable.meat)
            holder.textViewCategory.text = foodCategories[0]
            holder.textViewCategory.setBackgroundResource(R.drawable.round_corner_meat)



        }

        if (position == 1) {
            holder.imageViewCategory.setImageResource(R.drawable.vegetable)
            holder.textViewCategory.text = foodCategories[1]
            holder.textViewCategory.setBackgroundResource(R.drawable.round_corner_veg)

        }

        if (position == 2) {
            holder.imageViewCategory.setImageResource(R.drawable.chicken)
            holder.textViewCategory.text = foodCategories[2]
            holder.textViewCategory.setBackgroundResource(R.drawable.round_corner_chicken)

        }

        if (position == 3) {
            holder.imageViewCategory.setImageResource(R.drawable.fish)
            holder.textViewCategory.text = foodCategories[3]
            holder.textViewCategory.setBackgroundResource(R.drawable.round_corner_fish)

        }

        if (position == 4) {
            holder.imageViewCategory.setImageResource(R.drawable.cake)
            holder.textViewCategory.text = foodCategories[4]
            holder.textViewCategory.setBackgroundResource(R.drawable.round_corner_dessert)

        }


        holder.cardviewCategory.setOnClickListener {

            if (position == 0) {

                val recipe = meatRecipes

                holder.bundle.putString("meatCategory" , foodCategories[0] )

                holder.choosenCategoryFragment.arguments = holder.bundle
                homeFragment.activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.fragment_container, holder.choosenCategoryFragment)?.commit()

            }

            if (position == 1) {
                holder.bundle.putString("category" , foodCategories[1] )

                holder.choosenCategoryFragment.arguments = holder.bundle
                homeFragment.activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.fragment_container, holder.choosenCategoryFragment)?.commit()

            }

            if (position == 2) {
                holder.bundle.putString("category" , foodCategories[2] )

                holder.choosenCategoryFragment.arguments = holder.bundle
                homeFragment.activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.fragment_container, holder.choosenCategoryFragment)?.commit()

            }

            if (position == 3) {
                holder.bundle.putString("category" , foodCategories[3] )

                holder.choosenCategoryFragment.arguments = holder.bundle
                homeFragment.activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.fragment_container, holder.choosenCategoryFragment)?.commit()

            }

            if (position == 4) {
                holder.bundle.putString("category" , foodCategories[4] )

                holder.choosenCategoryFragment.arguments = holder.bundle
                homeFragment.activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.fragment_container, holder.choosenCategoryFragment)?.commit()

            }



        }


    }


   inner class CustomViewHolderCategory(val view: View): RecyclerView.ViewHolder(view) {

        val imageViewCategory = view.findViewById<ImageView>(R.id.image_category)
        val textViewCategory = view.findViewById<TextView>(R.id.textView_category)
        val cardviewCategory = view.findViewById<CardView>(R.id.cardview_food_category_row)

       val bundle = Bundle()
       val choosenCategoryFragment = ChoosenCategoryFragment()


    }

}

