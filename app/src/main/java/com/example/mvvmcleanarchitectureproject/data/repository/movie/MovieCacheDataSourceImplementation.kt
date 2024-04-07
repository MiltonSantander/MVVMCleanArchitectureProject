package com.example.mvvmcleanarchitectureproject.data.repository.movie

import com.example.mvvmcleanarchitectureproject.data.model.movie.Movie

class MovieCacheDataSourceImplementation : MovieCacheDataSource {
    private var movieList = ArrayList<Movie>()
    override suspend fun getMovieListFromCache(): List<Movie> {
        return movieList
    }

    override suspend fun saveMovieListToCache(movieListArgument: List<Movie>) {
        movieList.clear()
        movieList = ArrayList(movieListArgument)
    }

}