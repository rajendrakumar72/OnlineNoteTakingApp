package com.mrkumar.onlinenotetakingapp.data.model


import com.google.gson.annotations.SerializedName

data class ApiResponseModelItem(
    @SerializedName("age")
    val age: Int,
    @SerializedName("_id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("__v")
    val v: Int
)