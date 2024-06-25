package com.mvvm.app.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mvvm.app.data.remote.ApiRepository
import com.mvvm.app.data.remote.RetrofitService
import com.mvvm.app.ui.main.MainViewModel


class MainViewModelFactory() : ViewModelProvider.Factory {
    //private val movie: Movie = movie
    private val repository = ApiRepository(RetrofitService.getInstance())

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(repository) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class")
    }
}