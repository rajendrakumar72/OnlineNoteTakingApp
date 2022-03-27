package com.mrkumar.onlinenotetakingapp.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {

    private val BASE_URL="http://192.168.1.3:8080/api/"

    private fun getRetrofit():Retrofit{
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }
    val apiService:ApiService= getRetrofit().create(ApiService::class.java)
}