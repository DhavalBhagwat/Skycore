package com.example.skycore.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.skycore.pojo.Data
import com.example.skycore.pojo.Restaurant
import com.example.skycore.utils.MainRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel constructor(private val repository: MainRepository) : ViewModel() {

    val restaurantList = MutableLiveData<Data>()
    val errorMessage = MutableLiveData<String>()

    fun getAllRestaurants() {
        val response = repository.getAllRestaurants()
        response.enqueue(object : Callback<Data> {
            override fun onResponse(call: Call<Data>, response: Response<Data>) {
                Log.d("TAG", response.toString())
              //  restaurantList.postValue(response.body())
            }

            override fun onFailure(call: Call<Data>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }

}