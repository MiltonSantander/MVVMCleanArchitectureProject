package com.example.mvvmcleanarchitectureproject.data.repository.movie.datasourceimplementation

import com.example.mvvmcleanarchitectureproject.data.db.MovieDAO
import com.example.mvvmcleanarchitectureproject.data.model.movie.Movie
import com.example.mvvmcleanarchitectureproject.data.repository.movie.datasource.MovieLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieLocalDataSourceImplementation(private val movieDao: MovieDAO) : MovieLocalDataSource {
    override suspend fun getMovieListFromDB(): List<Movie> {
        return movieDao.getMovieList()
    }

    override suspend fun saveMovieListToDB(movieList: List<Movie>) {
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.saveMovieList(movieList)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.deleteMovieList()
        }
    }
}