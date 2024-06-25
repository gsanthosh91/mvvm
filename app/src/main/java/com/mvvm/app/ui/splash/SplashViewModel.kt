package com.mvvm.app.ui.splash

import android.os.Handler
import androidx.lifecycle.MutableLiveData
import com.mvvm.app.base.BaseViewModel

class SplashViewModel constructor() : BaseViewModel() {

    val loading = MutableLiveData<Boolean>(false)

    fun countdown() {
        Handler().postDelayed({
            loading.postValue(true)
        }, 2000)
    }

}