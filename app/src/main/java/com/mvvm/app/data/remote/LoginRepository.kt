package com.mvvm.app.data.remote

class LoginRepository constructor(private val retrofitService: RetrofitService) {

    suspend fun login() = retrofitService.login()

}