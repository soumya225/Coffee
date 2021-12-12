package com.example.coffeeit

object CoffeeAttributes {

    data class Result(
        val _id: String,
        val types: List<CoffeeType>,
        val sizes: List<CoffeeSize>,
        val extra: List<CoffeeExtra>
    )
    data class CoffeeType(
        val _id: String,
        val name: String,
        val sizes: List<String>,
        val extras: List<String>
    )

    data class CoffeeSize(
        val _id: String,
        val name: String
    )

    data class CoffeeExtra(
        val _id: Int,
        val name: String
    )

}


