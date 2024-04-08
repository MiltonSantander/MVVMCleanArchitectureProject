package com.example.mvvmcleanarchitectureproject.data.repository.movie.datasource

import com.example.mvvmcleanarchitectureproject.data.model.movie.Movie

interface MovieLocalDataSource {
    suspend fun getMovieListFromDB(): List<Movie>
    suspend fun saveMovieListToDB(movieList: List<Movie>)
    suspend fun clearAll()
}