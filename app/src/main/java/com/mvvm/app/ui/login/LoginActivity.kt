package com.mvvm.app.ui.login

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.mvvm.app.data.remote.LoginRepository
import com.mvvm.app.data.remote.RetrofitService
import com.mvvm.app.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    lateinit var viewModel: LoginViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this, LoginViewModelFactory()).get(LoginViewModel::class.java)

        viewModel.loginResponse.observe(this, {
            Log.d("DFERER", "onCreate: " + it)
        })

        viewModel.login()
    }
}