package com.example.mvvmcleanarchitectureproject.presentation.di.movie

import com.example.mvvmcleanarchitectureproject.domain.usecase.GetArtistListUseCase
import com.example.mvvmcleanarchitectureproject.domain.usecase.GetMovieListUseCase
import com.example.mvvmcleanarchitectureproject.domain.usecase.UpdateArtistListUseCase
import com.example.mvvmcleanarchitectureproject.domain.usecase.UpdateMovieListUseCase
import com.example.mvvmcleanarchitectureproject.presentation.artist.ArtistViewModelFactory
import com.example.mvvmcleanarchitectureproject.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {
    @MovieScope
    @Provides
    fun providerMovieViewModelFactory(
        getMovieListUseCase: GetMovieListUseCase,
        updateMovieListUseCase: UpdateMovieListUseCase
    ): MovieViewModelFactory {
        return MovieViewModelFactory(getMovieListUseCase, updateMovieListUseCase)
    }
}