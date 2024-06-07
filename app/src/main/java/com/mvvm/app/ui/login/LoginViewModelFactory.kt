package com.mvvm.app.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mvvm.app.data.remote.LoginRepository
import com.mvvm.app.data.remote.RetrofitService

class LoginViewModelFactory() : ViewModelProvider.Factory {
    private val repository = LoginRepository(RetrofitService.getInstance())
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            LoginViewModel(this.repository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}