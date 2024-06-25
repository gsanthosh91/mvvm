package com.mvvm.app.data.remote

class ApiRepository(private val retrofitService: RetrofitService) {
    suspend fun login() = retrofitService.login()
    suspend fun getAllMovies() = retrofitService.getAllMovies()

}