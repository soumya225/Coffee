package com.example.coffeeit.services

import com.example.coffeeit.models.CoffeeAttributes
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface ApiInterface {
    @Headers("Content-Type: application/json")
    @GET("60ba1ab72e35f2d9c786c610")
    fun fetchDeviceData(): Call<CoffeeAttributes.Result>
}