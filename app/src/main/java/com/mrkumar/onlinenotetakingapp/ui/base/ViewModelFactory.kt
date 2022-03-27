package com.mrkumar.onlinenotetakingapp.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mrkumar.onlinenotetakingapp.data.api.ApiHelper
import com.mrkumar.onlinenotetakingapp.data.repository.MainRepository
import com.mrkumar.onlinenotetakingapp.ui.main.viewmodel.MyViewModel

class ViewModelFactory(private val apiHelper: ApiHelper):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MyViewModel::class.java)){
            return MyViewModel(MainRepository(apiHelper)) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}