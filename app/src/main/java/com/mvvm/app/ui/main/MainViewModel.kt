package com.mvvm.app.ui.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.mvvm.app.Movie
import com.mvvm.app.base.BaseViewModel
import com.mvvm.app.data.remote.ApiRepository
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel constructor(private val repository: ApiRepository): BaseViewModel(){
    val errorMessage = MutableLiveData<String>()
    val movieList = MutableLiveData<List<Movie>>()
    var job: Job? = null
    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        onError("Exception handled: ${throwable.localizedMessage}")
    }
    //val loading = MutableLiveData(false)
    var loading = MutableLiveData<Boolean>(false)


    fun getAllMovies() {
        job = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
            loading.postValue(true)
            val response = repository.getAllMovies()
            withContext(Dispatchers.Main) {
                loading.postValue(false)
                if (response.isSuccessful) {
                    Log.d("TAG", "getAllMovies: " + response.body()?.size)
                    movieList.postValue(response.body()!!)
                } else {
                    onError("Error : ${response.message()} ")
                }
            }
        }

    }

    private fun onError(message: String) {
        errorMessage.value = message
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }

}