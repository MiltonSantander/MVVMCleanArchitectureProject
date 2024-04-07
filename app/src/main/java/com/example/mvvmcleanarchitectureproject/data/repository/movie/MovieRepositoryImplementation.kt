package com.example.mvvmcleanarchitectureproject.data.repository.movie

import android.util.Log
import com.example.mvvmcleanarchitectureproject.data.model.movie.Movie
import com.example.mvvmcleanarchitectureproject.domain.repository.MovieRepository

class MovieRepositoryImplementation(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieCacheDataSource: MovieCacheDataSource
) : MovieRepository {

    override suspend fun getMovieList(): List<Movie>? {
        return getMovieListFromCache()
    }

    override suspend fun updateMovieList(): List<Movie>? {
        val newMovieList = getMovieListFromAPI()
        movieLocalDataSource.clearAll()
        movieLocalDataSource.saveMovieListToDB(newMovieList)
        movieCacheDataSource.saveMovieListToCache(newMovieList)
        return newMovieList
    }

    suspend fun getMovieListFromAPI(): List<Movie> {
        lateinit var movieList: List<Movie>

        try {
            val response = movieRemoteDataSource.getMovieList()
            if (response.body() != null) {
                movieList = response.body()!!.movieList
            }
        } catch (exception: Exception) {
            Log.i("exceptionTag", exception.message.toString())
        }

        return movieList
    }

    suspend fun getMovieListFromDB(): List<Movie> {
        lateinit var movieList: List<Movie>

        try {
            movieList = movieLocalDataSource.getMovieListFromDB()
        } catch (exception: Exception) {
            Log.i("exceptionTag", exception.message.toString())
        }
        if (movieList.isNotEmpty()) {
            return movieList
        } else {
            movieList = getMovieListFromAPI()
            movieLocalDataSource.saveMovieListToDB(movieList)
        }

        return movieList
    }

    suspend fun getMovieListFromCache(): List<Movie> {
        lateinit var movieList: List<Movie>

        try {
            movieList = movieCacheDataSource.getMovieListFromCache()
        } catch (exception: Exception) {
            Log.i("exceptionTag", exception.message.toString())
        }
        if (movieList.isNotEmpty()) {
            return movieList
        } else {
            movieList = getMovieListFromDB()
            movieCacheDataSource.saveMovieListToCache(movieList)
        }

        return movieList
    }
}