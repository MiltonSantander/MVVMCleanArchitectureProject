package com.example.mvvmcleanarchitectureproject.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.mvvmcleanarchitectureproject.data.model.movie.Movie
import com.example.mvvmcleanarchitectureproject.domain.usecase.GetMovieListUseCase
import com.example.mvvmcleanarchitectureproject.domain.usecase.UpdateMovieListUseCase

class MovieViewModel(
    private val getMovieListUseCase: GetMovieListUseCase,
    private val updateMovieListUseCase: UpdateMovieListUseCase
) : ViewModel() {
    fun getMovieList() = liveData { emit(getMovieListUseCase.execute()) }
    fun updateMovieList() = liveData { emit(updateMovieListUseCase.execute()) }
}