package com.example.skycore.utils

import com.example.skycore.sync.RetrofitService

class MainRepository constructor(private val retrofitService: RetrofitService) {

    fun getAllRestaurants() = retrofitService.getRestaurants()
}