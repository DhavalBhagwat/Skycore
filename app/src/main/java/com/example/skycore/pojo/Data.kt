package com.example.skycore.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("businesses")
    @Expose
    val businesses: List<Restaurant>,

//    @SerializedName("total")
//    @Expose
//    val total: Int,
//
//    @SerializedName("region")
//    @Expose
//    val region: String
)