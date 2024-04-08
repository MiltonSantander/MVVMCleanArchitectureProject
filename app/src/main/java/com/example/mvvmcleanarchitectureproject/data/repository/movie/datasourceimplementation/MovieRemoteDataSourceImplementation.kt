package com.example.mvvmcleanarchitectureproject.data.repository.movie.datasourceimplementation

import com.example.mvvmcleanarchitectureproject.data.api.TMDBApi
import com.example.mvvmcleanarchitectureproject.data.model.movie.MovieListResponse
import com.example.mvvmcleanarchitectureproject.data.repository.movie.datasource.MovieRemoteDataSource
import retrofit2.Response

class MovieRemoteDataSourceImplementation(
    private val tmdbApi: TMDBApi,
    private val apiKey: String
) : MovieRemoteDataSource {
    override suspend fun getMovieList(): Response<MovieListResponse> {
        return tmdbApi.getPopularMovieList(apiKey)
    }
}