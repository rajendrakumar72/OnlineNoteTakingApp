package com.mrkumar.onlinenotetakingapp.data.api

class ApiHelper(private val apiService: ApiService) {

    suspend fun getData()=apiService.getAllData()
}