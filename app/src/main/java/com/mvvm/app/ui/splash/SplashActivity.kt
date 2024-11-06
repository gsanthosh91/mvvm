package com.mvvm.app.ui.splash

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.lifecycle.ViewModelProvider
import com.mvvm.app.base.BaseActivity
import com.mvvm.app.databinding.ActivitySplashBinding
import com.mvvm.app.factory.SplashViewModelFactory
import com.mvvm.app.ui.main.MainActivity


class SplashActivity : BaseActivity<ActivitySplashBinding, SplashViewModel>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.loading.observe(this) {
            if (it == true) {
                startActivity(Intent(this, MainActivity::class.java))
            }
        }
        viewModel.countdown();
    }

    override fun createViewBinding(layoutInflater: LayoutInflater): ActivitySplashBinding {
        return ActivitySplashBinding.inflate(layoutInflater)
    }

    override fun createViewModel(): SplashViewModel {
        return ViewModelProvider(this, SplashViewModelFactory())[SplashViewModel::class.java]
    }

}