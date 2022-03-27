package com.mrkumar.onlinenotetakingapp.data.api

import com.mrkumar.onlinenotetakingapp.data.model.ApiResponseModel
import com.mrkumar.onlinenotetakingapp.data.model.ApiResponseModelItem
import retrofit2.http.GET

interface ApiService {

    @GET("getAll")
    suspend fun getAllData():List<ApiResponseModelItem>

}