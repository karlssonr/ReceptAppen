package com.example.receptappen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.food_category_row.view.*


class AdapterFoodCategory: RecyclerView.Adapter<CustomViewHolderCategory>() {

    val foodCategories = listOf<String>("KÖTT","VEG","FÅGEL","FISK","DESSERT")

    override fun getItemCount(): Int {
        return foodCategories.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolderCategory {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellForRow = layoutInflater.inflate(R.layout.food_category_row, parent, false)
        return CustomViewHolderCategory(cellForRow)

    }

    override fun onBindViewHolder(holder: CustomViewHolderCategory, position: Int) {

        val imageViewCategory = holder.view.image_category
        val textViewCategory = holder.view.textView_category
      /*  holder?.view?.textView_category.text = "VEG"*/

        if (position == 0) {
            imageViewCategory.setImageResource(R.drawable.meat)
            textViewCategory.text = foodCategories[0]

        }

        if (position == 1) {
            imageViewCategory.setImageResource(R.drawable.vegetable)
            textViewCategory.text = foodCategories[1]
            textViewCategory.setBackgroundResource(R.drawable.round_corner_veg)

        }

        if (position == 2) {
            imageViewCategory.setImageResource(R.drawable.chicken)
            textViewCategory.text = foodCategories[2]

        }

        if (position == 3) {
            imageViewCategory.setImageResource(R.drawable.fish)
            textViewCategory.text = foodCategories[3]

        }

        if (position == 4) {
            imageViewCategory.setImageResource(R.drawable.cake)
            textViewCategory.text = foodCategories[4]

        }




    }


}

class CustomViewHolderCategory(val view: View): RecyclerView.ViewHolder(view) {

    var foodCategotyPosition = 0

}