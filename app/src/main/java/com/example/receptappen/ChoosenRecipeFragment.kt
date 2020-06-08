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


        /*      val allRecipeImage = intent.getStringExtra("allRecipeImage")
              val allRecipeTitle = intent.getStringExtra("allRecipeTitle")
              val allRecipeCategory = intent.getStringExtra("allRecipeCategory")
              val allRecipeDescription = intent.getStringExtra("allRecipeDescription")
              val allRecipeIngrediens = intent.getStringExtra("allRecipeIngrediens")
              val allRecipeTime = intent.getStringExtra("allRecipeCooktime")*/

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

        return view
    }

    companion object {

        fun newInstance() = ChoosenRecipeFragment()


    }
}