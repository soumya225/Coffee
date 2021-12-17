package com.example.coffeeit.helpers

import com.example.coffeeit.models.CoffeeItem

class OnClickListener(val clickListener: (coffeeItem: CoffeeItem) -> Unit) {
    fun onClick(coffeeItem: CoffeeItem) = clickListener(coffeeItem)
}