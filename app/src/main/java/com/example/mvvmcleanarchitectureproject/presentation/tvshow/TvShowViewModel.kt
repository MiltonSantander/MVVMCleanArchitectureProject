package com.example.mvvmcleanarchitectureproject.presentation.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.mvvmcleanarchitectureproject.domain.usecase.GetTvShowListUseCase
import com.example.mvvmcleanarchitectureproject.domain.usecase.UpdateTvShowListUseCase

class TvShowViewModel(
    private val getTvShowListUseCase: GetTvShowListUseCase,
    private val updateTvShowListUseCase: UpdateTvShowListUseCase
) : ViewModel() {
    fun getTvShowList() = liveData { emit(getTvShowListUseCase.execute()) }
    fun updateTvShowList() = liveData { emit(updateTvShowListUseCase.execute()) }
}