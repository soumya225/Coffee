package com.example.coffeeit

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel(){
    private var homeRepository:HomeRepository?=null
    var coffeeAttributesLiveData : LiveData<CoffeeAttributes.Result>?=null

    init {
        homeRepository = HomeRepository()
        coffeeAttributesLiveData = MutableLiveData()
    }

    fun fetchDeviceDetails(){
        coffeeAttributesLiveData = homeRepository?.fetchDeviceDetails()
    }
}