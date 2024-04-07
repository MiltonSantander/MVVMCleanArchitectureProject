package com.example.mvvmcleanarchitectureproject.data.repository.movie

import com.example.mvvmcleanarchitectureproject.data.model.movie.MovieListResponse
import retrofit2.Response

interface MovieRemoteDataSource {
    suspend fun getMovieList(): Response<MovieListResponse>
}