package com.example.mvvmcleanarchitectureproject.data.api

import com.example.mvvmcleanarchitectureproject.data.model.artist.ArtistListResponse
import com.example.mvvmcleanarchitectureproject.data.model.movie.MovieListResponse
import com.example.mvvmcleanarchitectureproject.data.model.tvshow.TvShowListResponse
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