package com.example.mvvmcleanarchitectureproject.data.repository.movie

import com.example.mvvmcleanarchitectureproject.data.model.movie.Movie

interface MovieCacheDataSource {
    suspend fun getMovieListFromCache(): List<Movie>
    suspend fun saveMovieListToCache(movieList: List<Movie>)
}