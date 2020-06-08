package com.example.receptappen

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class ChoosenRecipeFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)




    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_chosen_recipe, container, false)
        val activity = activity as Context



        val choosenRecipeImage = view?.findViewById<ImageView>(R.id.imageView_choosen_recipe)
        val choosenRecipeTitle = view?.findViewById<TextView>(R.id.textView_choosen_recipe_title)
        val choosenRecipeTime = view?.findViewById<TextView>(R.id.textView_choosen_recipe_time)
        val choosenRecipeCategory = view?.findViewById<TextView>(R.id.textView_choosen_recipe_category)
        val choosenRecipeIngrediens = view?.findViewById<TextView>(R.id.textView_choosen_recipe_ingrediens)
        val choosenRecipeDescription = view?.findViewById<TextView>(R.id.textView_choosen_recipe_description)



        val allRecipeImage = arguments?.getString("allRecipeImage")
        val allRecipeTitle = arguments?.getString("allRecipeTitle")
        val allRecipeCategory = arguments?.getString("allRecipeCategory")
        val allRecipeDescription = arguments?.getString("allRecipeDescription")
        val allRecipeIngrediens = arguments?.getString("allRecipeIngrediens")
        val allRecipeTime = arguments?.getString("allRecipeTime")

        Picasso.with(activity).load(allRecipeImage).into(choosenRecipeImage)
        choosenRecipeCategory?.text = allRecipeCategory
        choosenRecipeTime?.text = allRecipeTime
        choosenRecipeTitle?.text = allRecipeTitle
        choosenRecipeDescription?.text = allRecipeDescription
        choosenRecipeIngrediens?.text = allRecipeIngrediens

        val fishRecipeImage = arguments?.getString("fishRecipeImage")
        val fishRecipeTitle = arguments?.getString("fishRecipeTitle")
        val fishRecipeCategory = arguments?.getString("fishRecipeCategory")
        val fishRecipeDescription = arguments?.getString("fishRecipeDescription")
        val fishRecipeIngrediens = arguments?.getString("fishRecipeIngrediens")
        val fishRecipeTime = arguments?.getString("fishRecipeTime")

        if (fishRecipeImage != null) {

            Picasso.with(activity).load(fishRecipeImage).into(choosenRecipeImage)
            choosenRecipeCategory?.text = fishRecipeCategory
            choosenRecipeTime?.text = fishRecipeTime
            choosenRecipeTitle?.text = fishRecipeTitle
            choosenRecipeDescription?.text = fishRecipeDescription
            choosenRecipeIngrediens?.text = fishRecipeIngrediens


        }


        val vegRecipeImage = arguments?.getString("vegRecipeImage")
        val vegRecipeTitle = arguments?.getString("vegRecipeTitle")
        val vegRecipeCategory = arguments?.getString("vegRecipeCategory")
        val vegRecipeDescription = arguments?.getString("vegRecipeDescription")
        val vegRecipeIngrediens = arguments?.getString("vegRecipeIngrediens")
        val vegRecipeTime = arguments?.getString("vegRecipeTime")

        if (vegRecipeImage != null) {

            Picasso.with(activity).load(vegRecipeImage).into(choosenRecipeImage)
            choosenRecipeCategory?.text = vegRecipeCategory
            choosenRecipeTime?.text = vegRecipeTime
            choosenRecipeTitle?.text = vegRecipeTitle
            choosenRecipeDescription?.text = vegRecipeDescription
            choosenRecipeIngrediens?.text = vegRecipeIngrediens


        }

        val meatRecipeImage = arguments?.getString("meatRecipeImage")
        val meatRecipeTitle = arguments?.getString("meatRecipeTitle")
        val meatRecipeCategory = arguments?.getString("meatRecipeCategory")
        val meatRecipeDescription = arguments?.getString("meatRecipeDescription")
        val meatRecipeIngrediens = arguments?.getString("meatRecipeIngrediens")
        val meatRecipeTime = arguments?.getString("meatRecipeTime")

        if (meatRecipeImage != null) {

            Picasso.with(activity).load(meatRecipeImage).into(choosenRecipeImage)
            choosenRecipeCategory?.text = meatRecipeCategory
            choosenRecipeTime?.text = meatRecipeTime
            choosenRecipeTitle?.text = meatRecipeTitle
            choosenRecipeDescription?.text = meatRecipeDescription
            choosenRecipeIngrediens?.text = meatRecipeIngrediens


        }



        val dessertRecipeImage = arguments?.getString("dessertRecipeImage")
        val dessertRecipeTitle = arguments?.getString("dessertRecipeTitle")
        val dessertRecipeCategory = arguments?.getString("dessertRecipeCategory")
        val dessertRecipeDescription = arguments?.getString("dessertRecipeDescription")
        val dessertRecipeIngrediens = arguments?.getString("dessertRecipeIngrediens")
        val dessertRecipeTime = arguments?.getString("dessertRecipeTime")

        if (dessertRecipeImage != null) {

            Picasso.with(activity).load(dessertRecipeImage).into(choosenRecipeImage)
            choosenRecipeCategory?.text = dessertRecipeCategory
            choosenRecipeTime?.text = dessertRecipeTime
            choosenRecipeTitle?.text = dessertRecipeTitle
            choosenRecipeDescription?.text = dessertRecipeDescription
            choosenRecipeIngrediens?.text = dessertRecipeIngrediens


        }

        val chickenRecipeImage = arguments?.getString("chickenRecipeImage")
        val chickenRecipeTitle = arguments?.getString("chickenRecipeTitle")
        val chickenRecipeCategory = arguments?.getString("chickenRecipeCategory")
        val chickenRecipeDescription = arguments?.getString("chickenRecipeDescription")
        val chickenRecipeIngrediens = arguments?.getString("chickenRecipeIngrediens")
        val chickenRecipeTime = arguments?.getString("chickenRecipeTime")

        if (chickenRecipeImage != null) {

            Picasso.with(activity).load(chickenRecipeImage).into(choosenRecipeImage)
            choosenRecipeCategory?.text = chickenRecipeCategory
            choosenRecipeTime?.text = chickenRecipeTime
            choosenRecipeTitle?.text = chickenRecipeTitle
            choosenRecipeDescription?.text = chickenRecipeDescription
            choosenRecipeIngrediens?.text = chickenRecipeIngrediens


        }

        if (choosenRecipeCategory?.text == "KÖTT") {
            choosenRecipeCategory.setBackgroundResource(R.drawable.round_corner_meat)
        }

        if (choosenRecipeCategory?.text == "VEG") {
            choosenRecipeCategory.setBackgroundResource(R.drawable.round_corner_veg)
        }

        if (choosenRecipeCategory?.text == "FÅGEL") {
            choosenRecipeCategory.setBackgroundResource(R.drawable.round_corner_chicken)
        }

        if (choosenRecipeCategory?.text == "FISK") {
            choosenRecipeCategory.setBackgroundResource(R.drawable.round_corner_fish)
        }

        if (choosenRecipeCategory?.text == "DESSERT") {
            choosenRecipeCategory.setBackgroundResource(R.drawable.round_corner_dessert)
        }




        return view
    }


    companion object {

        fun newInstance() = ChoosenRecipeFragment()


    }
}