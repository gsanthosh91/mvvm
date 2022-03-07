package com.mvvm.app.util

import com.mvvm.app.Movie

object ValidationUtil {

    fun validateMovie(movie: Movie): Boolean {
        if (movie.title.isNotEmpty() && movie.body.isNotEmpty()) {
            return true
        }
        return false
    }
}