package com.example.coffeeit

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeRepository {
    val apiInterface = ApiClient.getApiClient().create(ApiInterface::class.java)

    fun fetchDeviceDetails(): LiveData<CoffeeAttributes.Result> {
        val data = MutableLiveData<CoffeeAttributes.Result>()

        apiInterface.fetchDeviceData().enqueue(object : Callback<CoffeeAttributes.Result> {

            override fun onFailure(call: Call<CoffeeAttributes.Result>, t: Throwable) {
                Log.e("=======", t.toString())
                data.value = null
            }

            override fun onResponse(
                call: Call<CoffeeAttributes.Result>,
                response: Response<CoffeeAttributes.Result>
            ) {
                val res = response.body()
                Log.e("=======", res.toString())
                if (response.code() == 200 &&  res!=null){
                    data.value = res
                }else{
                    data.value = null
                }
            }
        })

        return data
    }
}