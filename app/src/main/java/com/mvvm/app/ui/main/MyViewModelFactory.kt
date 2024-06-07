package com.mvvm.app.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mvvm.app.data.remote.MainRepository
import com.mvvm.app.data.remote.RetrofitService

class MyViewModelFactory constructor(): ViewModelProvider.Factory {
    val repository = MainRepository(RetrofitService.getInstance())
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            MainViewModel(this.repository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}