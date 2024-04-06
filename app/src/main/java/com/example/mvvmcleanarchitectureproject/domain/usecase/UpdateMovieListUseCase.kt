package com.example.mvvmcleanarchitectureproject.domain.usecase

import com.example.mvvmcleanarchitectureproject.data.model.movie.Movie
import com.example.mvvmcleanarchitectureproject.domain.repository.MovieRepository

class UpdateMovieListUseCase(private val movieRepository: MovieRepository) {
    suspend fun execute(): List<Movie>? = movieRepository.updateMovieList()
}