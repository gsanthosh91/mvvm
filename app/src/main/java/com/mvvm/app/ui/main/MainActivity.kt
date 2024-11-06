package com.mvvm.app.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import androidx.lifecycle.ViewModelProvider
import com.mvvm.app.MovieAdapter
import com.mvvm.app.base.BaseActivity
import com.mvvm.app.databinding.ActivityMainBinding
import com.mvvm.app.factory.MainViewModelFactory

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {
    private val adapter = MovieAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel


        binding.recyclerview.adapter = adapter

        viewModel.movieList.observe(this) {
            adapter.setMovies(it)
        }
        viewModel.getAllMovies();
    }

    override fun createViewModel(): MainViewModel {
        return ViewModelProvider(this, MainViewModelFactory())[MainViewModel::class.java]
    }

    override fun createViewBinding(layoutInflater: LayoutInflater): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }
}