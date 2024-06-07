package com.mvvm.app.ui.splash

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.mvvm.app.databinding.ActivitySplashBinding
import com.mvvm.app.ui.main.MainActivity

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    lateinit var binding: ActivitySplashBinding
    lateinit var viewModel: SplashViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this, SplashViewModelFactory()).get(SplashViewModel::class.java)

        viewModel.loading.observe(this) {
            if (it) {
                startActivity(Intent(this, MainActivity::class.java))
            }
        }

        viewModel.countdown()
    }
}