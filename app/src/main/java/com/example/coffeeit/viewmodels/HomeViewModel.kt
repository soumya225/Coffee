package com.example.coffeeit.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.coffeeit.services.HomeRepository
import com.example.coffeeit.models.CoffeeAttributes
import com.example.coffeeit.models.CoffeeItem

class HomeViewModel : ViewModel(){
    private var homeRepository: HomeRepository?=null
    var coffeeAttributesLiveData : LiveData<CoffeeAttributes.Result?>?=null

    private val _chosenStyle = MutableLiveData<String>()
    val chosenStyle: LiveData<String> = _chosenStyle

    private val _chosenSize = MutableLiveData<String>()
    val chosenSize: LiveData<String> = _chosenSize

    init {
        homeRepository = HomeRepository()
        coffeeAttributesLiveData = MutableLiveData()
    }

    fun setChosenStyle(desiredStyle: String) {
        _chosenStyle.value = desiredStyle
    }

    fun setChosenSize(desiredSize: String) {
        _chosenSize.value = desiredSize
    }

    fun fetchDeviceDetails(){
        coffeeAttributesLiveData = homeRepository?.fetchDeviceDetails()
    }

    fun getStyles(): MutableList<CoffeeItem> {
        val output = mutableListOf<CoffeeItem>()
        for (i in coffeeAttributesLiveData?.value?.types!!){

            val coffeeItem = CoffeeItem(name = i.name)

            output.add(coffeeItem)
        }
        return output
    }

    fun getSizes(): MutableList<CoffeeItem> {
        val coffeeTypeName = chosenStyle.value
        val result = coffeeAttributesLiveData?.value
        val output = mutableListOf<CoffeeItem>()
        val coffeeType = result?.types?.findLast { it.name == coffeeTypeName }
        if (coffeeType != null) {
            for (i in coffeeType.sizes){
                val size = result.sizes.findLast { it._id == i }

                val coffeeItem = size?.let { CoffeeItem(name = it.name) }

                if (coffeeItem != null) {
                    output.add(coffeeItem)
                }
            }
        }
        return output
    }
}