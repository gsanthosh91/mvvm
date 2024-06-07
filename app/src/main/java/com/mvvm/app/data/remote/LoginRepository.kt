package com.mvvm.app.data.remote

class LoginRepository(private val retrofitService: RetrofitService) {

    suspend fun login() = retrofitService.login()

}