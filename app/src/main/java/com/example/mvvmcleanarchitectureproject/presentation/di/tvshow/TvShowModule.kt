package com.example.mvvmcleanarchitectureproject.presentation.di.tvshow

import com.example.mvvmcleanarchitectureproject.domain.usecase.GetTvShowListUseCase
import com.example.mvvmcleanarchitectureproject.domain.usecase.UpdateTvShowListUseCase
import com.example.mvvmcleanarchitectureproject.presentation.tvshow.TvShowViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TvShowModule {
    @TvShowScope
    @Provides
    fun providerTvShowViewModelFactory(
        getTvShowListUseCase: GetTvShowListUseCase,
        updateTvShowListUseCase: UpdateTvShowListUseCase
    ): TvShowViewModelFactory {
        return TvShowViewModelFactory(getTvShowListUseCase, updateTvShowListUseCase)
    }
}