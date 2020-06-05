package com.example.receptappen

data class Recipe(var title: String = "",
             var category: String = "",
             var cookTime: String = "",
             var image: String = "",
             var ingredients: String = "",
             var description: String = "",
                  var saveFavorite : Boolean = false) {

    
}