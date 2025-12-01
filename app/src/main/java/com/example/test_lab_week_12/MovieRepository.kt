package com.example.test_lab_week_12

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.test_lab_week_12.api.MovieService
import com.example.test_lab_week_12.model.Movie

class MovieRepository(private val movieService: MovieService) {


    private val apiKey = "9354f0ce5aeda8ea7fde7d4b058b7a44"


    private val movieLiveData = MutableLiveData<List<Movie>>()
    val movies: LiveData<List<Movie>>
        get() = movieLiveData


    private val errorLiveData = MutableLiveData<String>()
    val error: LiveData<String>
        get() = errorLiveData


    suspend fun fetchMovies() {
        try {

            val popularMovies = movieService.getPopularMovies(apiKey)
            movieLiveData.postValue(popularMovies.results)
        } catch (exception: Exception) {

            errorLiveData.postValue("An error occurred: ${exception.message}")
        }
    }
}