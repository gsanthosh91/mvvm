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
        //val movie: Movie = intent.getParcelableExtra(EXTRA_MOVIE)
        return ViewModelProvider(this, MainViewModelFactory())[MainViewModel::class.java]
    }

    override fun createViewBinding(layoutInflater: LayoutInflater): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }
}


/*lateinit var viewModel: MainViewModel
private val adapter = MovieAdapter()
lateinit var binding: ActivityMainBinding

override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    binding.setLifecycleOwner(this);
    setContentView(binding.root)
    viewModel = ViewModelProvider(this, MyViewModelFactory())[MainViewModel::class.java]
    binding.viewModel = viewModel

    binding.recyclerview.adapter = adapter

    viewModel.movieList.observe(this, {
        adapter.setMovies(it)
    })

    *//*viewModel.errorMessage.observe(this, {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        })

        viewModel.loading.observe(this, Observer {
            if (it) {
                binding.progressDialog.visibility = View.VISIBLE
            } else {
                binding.progressDialog.visibility = View.GONE
            }
        })*//*

        viewModel.getAllMovies()

    }*/