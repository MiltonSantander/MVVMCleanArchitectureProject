package com.example.mvvmcleanarchitectureproject.data.repository.movie.datasource

import com.example.mvvmcleanarchitectureproject.data.model.movie.MovieListResponse
import retrofit2.Response

interface MovieRemoteDataSource {
    suspend fun getMovieList(): Response<MovieListResponse>
}