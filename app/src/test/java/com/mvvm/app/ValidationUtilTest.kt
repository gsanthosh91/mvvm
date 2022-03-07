package com.mvvm.app

import com.mvvm.app.util.ValidationUtil
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class ValidationUtilTest {

    @Test
    fun validateMovieTest() {
        val movie = Movie("test","testUrl","main")
        assertEquals(true, ValidationUtil.validateMovie(movie))
    }

    @Test
    fun validateMovieEmptyTest() {
        val movie = Movie("","testUrl","main")
        assertEquals(false, ValidationUtil.validateMovie(movie))
    }

}