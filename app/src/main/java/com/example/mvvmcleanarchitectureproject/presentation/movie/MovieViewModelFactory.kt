package com.example.mvvmcleanarchitectureproject.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmcleanarchitectureproject.domain.usecase.GetMovieListUseCase
import com.example.mvvmcleanarchitectureproject.domain.usecase.UpdateMovieListUseCase

class MovieViewModelFactory(
    private val getMovieListUseCase: GetMovieListUseCase,
    private val updateMovieListUseCase: UpdateMovieListUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MovieViewModel(getMovieListUseCase, updateMovieListUseCase) as T
    }
}