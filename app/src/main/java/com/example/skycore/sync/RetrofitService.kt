package com.example.skycore.sync

import com.example.skycore.pojo.Data
import com.example.skycore.pojo.Restaurant
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*
import okhttp3.Interceptor

import okhttp3.OkHttpClient
import okhttp3.Request


interface RetrofitService {

    @GET("/v3/businesses/search")
    fun getRestaurants(
        //@Header("Authorization") token: String = "Bearer $API_KEY",
        @Query("term") term: String? = "restaurants",
        @Query("location") location: String? = "MUM",
        @Query("radius") radius: Int? = 500,
        @Query("sort_by") sort_by: String? = "distance",
        @Query("limit") limit: Int? = 15,
        @Query("offset") offset: Int? = 0,
    ): Call<Data>

    companion object {

        var retrofitService: RetrofitService? = null
        var API_KEY = "XPFgzKwZGK1yqRxHi0d5xsARFOLpXIvccQj5jekqTnysweGyoIfVUHcH2tPfGq5Oc9kwKHPkcOjk2d1Xobn7aTjOFeop8x41IUfVvg2Y27KiINjYPADcE7Qza0RkX3Yx"

        fun getInstance(): RetrofitService {
            if (retrofitService == null) {
                val client = OkHttpClient.Builder().addInterceptor { chain ->
                    val newRequest = chain.request().newBuilder().addHeader("Authorization", "Bearer $API_KEY").build()
                    chain.proceed(newRequest)
                }.build()
                val retrofit = Retrofit.Builder().baseUrl("https://api.yelp.com").addConverterFactory(GsonConverterFactory.create()).client(client).build()
                retrofitService = retrofit.create(RetrofitService::class.java)
            }
            return retrofitService!!
        }
    }

}