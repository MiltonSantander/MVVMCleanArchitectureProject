package com.example.mvvmcleanarchitectureproject.presentation.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmcleanarchitectureproject.domain.usecase.GetTvShowListUseCase
import com.example.mvvmcleanarchitectureproject.domain.usecase.UpdateTvShowListUseCase

class TvShowViewModelFactory(
    private val getTvShowListUseCase: GetTvShowListUseCase,
    private val updateTvShowListUseCase: UpdateTvShowListUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TvShowViewModel(getTvShowListUseCase, updateTvShowListUseCase) as T
    }
}