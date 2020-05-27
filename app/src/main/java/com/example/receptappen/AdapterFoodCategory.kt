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
        holder?.view?.textView_category.text = "VEG"




    }


}

class CustomViewHolderCategory(val view: View): RecyclerView.ViewHolder(view) {

}