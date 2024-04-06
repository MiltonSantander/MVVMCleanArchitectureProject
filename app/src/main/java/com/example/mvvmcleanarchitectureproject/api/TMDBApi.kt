package com.example.mvvmcleanarchitectureproject.api

import com.example.mvvmcleanarchitectureproject.data.ArtistListResponse
import com.example.mvvmcleanarchitectureproject.data.MovieListResponse
import com.example.mvvmcleanarchitectureproject.data.TvShowListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBApi {
    @GET("movie/popular")
    suspend fun getPopularMovieList(@Query("api_key") apiKey: String): Response<MovieListResponse>

    @GET("tv/popular")
    suspend fun getPopularTvShowList(@Query("api_key") apiKey: String): Response<TvShowListResponse>

    @GET("person/popular")
    suspend fun getPopularArtistList(@Query("api_key") apiKey: String): Response<ArtistListResponse>
}