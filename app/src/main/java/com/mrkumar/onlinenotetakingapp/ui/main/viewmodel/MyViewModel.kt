package com.mrkumar.onlinenotetakingapp.ui.main.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.mrkumar.onlinenotetakingapp.data.repository.MainRepository
import com.mrkumar.onlinenotetakingapp.utlis.Resource
import kotlinx.coroutines.Dispatchers

class MyViewModel(private val mainRepository: MainRepository):ViewModel() {

    fun getData()= liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = mainRepository.getUser()))
        }catch (e:Exception){
            Log.e("TAG", "exe: ${e.localizedMessage}" )
        }
    }
}