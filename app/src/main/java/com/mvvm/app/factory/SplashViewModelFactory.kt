package com.mvvm.app.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mvvm.app.ui.splash.SplashViewModel


class SplashViewModelFactory() : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SplashViewModel::class.java)) {
            return SplashViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}