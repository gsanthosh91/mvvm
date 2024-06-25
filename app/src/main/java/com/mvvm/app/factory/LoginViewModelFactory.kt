package com.mvvm.app.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mvvm.app.data.remote.ApiRepository
import com.mvvm.app.data.remote.RetrofitService
import com.mvvm.app.ui.login.LoginViewModel

class LoginViewModelFactory() : ViewModelProvider.Factory {
    private val repository = ApiRepository(RetrofitService.getInstance())
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            LoginViewModel(this.repository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}