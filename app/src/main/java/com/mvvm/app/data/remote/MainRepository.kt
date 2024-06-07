package com.mvvm.app.data.remote

class MainRepository(private val retrofitService: RetrofitService) {

    suspend fun getAllMovies() = retrofitService.getAllMovies()

}