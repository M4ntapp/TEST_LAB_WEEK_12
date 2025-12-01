package com.example.test_lab_week_12

import com.example.test_lab_week_12.api.MovieService
import com.example.test_lab_week_12.model.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class MovieRepository(private val movieService: MovieService) {

    private val apiKey = "9354f0ce5aeda8ea7fde7d4b058b7a44"


    fun fetchMovies(): Flow<List<Movie>> {
        return flow {

            emit(movieService.getPopularMovies(apiKey).results)

        }.flowOn(Dispatchers.IO)
    }
}