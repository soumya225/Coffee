package com.example.coffeeit.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.coffeeit.services.HomeRepository
import com.example.coffeeit.models.CoffeeAttributes

class HomeViewModel : ViewModel(){
    private var homeRepository: HomeRepository?=null
    var coffeeAttributesLiveData : LiveData<CoffeeAttributes.Result>?=null

    init {
        homeRepository = HomeRepository()
        coffeeAttributesLiveData = MutableLiveData()
    }

    fun fetchDeviceDetails(){
        coffeeAttributesLiveData = homeRepository?.fetchDeviceDetails()
    }
}