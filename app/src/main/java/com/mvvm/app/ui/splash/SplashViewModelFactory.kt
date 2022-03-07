package com.mvvm.app.ui.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mvvm.app.data.remote.LoginRepository

class SplashViewModelFactory constructor(): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(SplashViewModel::class.java)) {
            SplashViewModel() as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}