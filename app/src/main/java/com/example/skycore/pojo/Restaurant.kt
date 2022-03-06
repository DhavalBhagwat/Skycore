package com.example.skycore.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Restaurant(
    @SerializedName("name")
    @Expose
    val name: String,

    @SerializedName("image_url")
    @Expose
    val imageUrl: String,

    @SerializedName("distance")
    @Expose
    val distance: Double,

    @SerializedName("location")
    @Expose
    val location: Any,

    @SerializedName("rating")
    @Expose
    val rating: Float,

    @SerializedName("is_closed")
    @Expose
    val isClosed: Boolean
)
