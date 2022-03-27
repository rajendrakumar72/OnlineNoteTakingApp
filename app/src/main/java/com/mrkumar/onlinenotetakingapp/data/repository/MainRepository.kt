package com.mrkumar.onlinenotetakingapp.data.repository

import com.mrkumar.onlinenotetakingapp.data.api.ApiHelper

class MainRepository (private val apiHelper: ApiHelper) {
    suspend fun getUser()=apiHelper.getData()
}