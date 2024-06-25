package com.mvvm.app.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mvvm.app.data.remote.ApiRepository
import com.mvvm.app.data.remote.RetrofitService
import com.mvvm.app.ui.main.MainViewModel
import com.mvvm.app.ui.splash.SplashViewModel

class MyViewModelFactory constructor() : ViewModelProvider.Factory {
    private val repository = ApiRepository(RetrofitService.getInstance())
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(SplashViewModel::class.java)) {
            SplashViewModel() as T
        } else if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            MainViewModel(repository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}