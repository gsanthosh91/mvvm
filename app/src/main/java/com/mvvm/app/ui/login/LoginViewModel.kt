package com.mvvm.app.ui.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mvvm.app.data.remote.MainRepository
import com.mvvm.app.Movie
import com.mvvm.app.data.remote.LoginRepository
import kotlinx.coroutines.*

class LoginViewModel constructor(private val repository: LoginRepository) : ViewModel() {

    val errorMessage = MutableLiveData<String>()
    val loginResponse = MutableLiveData<Any>()
    var job: Job? = null
    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        onError("Exception handled: ${throwable.localizedMessage}")
    }
    val loading = MutableLiveData<Boolean>()

    fun login() {

        job = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
            loading.postValue(true)
            val response = repository.login()
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    loginResponse.postValue(response.body())
                    loading.value = false
                } else {
                    onError("Error : ${response.message()} ")
                }
            }
        }

    }

    private fun onError(message: String) {
        errorMessage.value = message
        loading.value = false
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }

}