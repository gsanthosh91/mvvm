package com.mvvm.app.ui.splash

import android.os.Handler
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SplashViewModel constructor() : ViewModel() {

    val loading = MutableLiveData<Boolean>()

    fun countdown() {
        Handler().postDelayed({
            loading.postValue(true)
        }, 5000)
    }

}