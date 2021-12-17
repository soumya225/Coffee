package com.example.coffeeit.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.coffeeit.services.HomeRepository
import com.example.coffeeit.models.CoffeeAttributes

class HomeViewModel : ViewModel(){
    private var homeRepository: HomeRepository?=null
    var coffeeAttributesLiveData : LiveData<CoffeeAttributes.Result>?=null

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
}