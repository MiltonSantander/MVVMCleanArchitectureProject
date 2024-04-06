package com.example.mvvmcleanarchitectureproject.domain.repository

import com.example.mvvmcleanarchitectureproject.data.model.movie.Movie

interface MovieRepository {
    suspend fun getMovieList(): List<Movie>?
    suspend fun updateMovieList(): List<Movie>?
}