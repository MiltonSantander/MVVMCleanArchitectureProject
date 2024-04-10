package com.example.mvvmcleanarchitectureproject.presentation.di

import com.example.mvvmcleanarchitectureproject.domain.repository.ArtistRepository
import com.example.mvvmcleanarchitectureproject.domain.repository.MovieRepository
import com.example.mvvmcleanarchitectureproject.domain.repository.TvShowRepository
import com.example.mvvmcleanarchitectureproject.domain.usecase.GetArtistListUseCase
import com.example.mvvmcleanarchitectureproject.domain.usecase.GetMovieListUseCase
import com.example.mvvmcleanarchitectureproject.domain.usecase.GetTvShowListUseCase
import com.example.mvvmcleanarchitectureproject.domain.usecase.UpdateArtistListUseCase
import com.example.mvvmcleanarchitectureproject.domain.usecase.UpdateMovieListUseCase
import com.example.mvvmcleanarchitectureproject.domain.usecase.UpdateTvShowListUseCase
import dagger.Provides

class UseCaseModule {
    @Provides
    fun provideGetMovieListUseCase(movieRepository: MovieRepository): GetMovieListUseCase {
        return GetMovieListUseCase(movieRepository)
    }

    @Provides
    fun provideUpdateMovieListUseCase(movieRepository: MovieRepository): UpdateMovieListUseCase {
        return UpdateMovieListUseCase(movieRepository)
    }

    @Provides
    fun provideGetArtistListUseCase(artistRepository: ArtistRepository): GetArtistListUseCase {
        return GetArtistListUseCase(artistRepository)
    }

    @Provides
    fun provideUpdateArtistListUseCase(artistRepository: ArtistRepository): UpdateArtistListUseCase {
        return UpdateArtistListUseCase(artistRepository)
    }

    @Provides
    fun provideGetTvShowListUseCase(tvShowRepository: TvShowRepository): GetTvShowListUseCase {
        return GetTvShowListUseCase(tvShowRepository)
    }

    @Provides
    fun provideUpdateTvShowListUseCase(tvShowRepository: TvShowRepository): UpdateTvShowListUseCase {
        return UpdateTvShowListUseCase(tvShowRepository)
    }
}