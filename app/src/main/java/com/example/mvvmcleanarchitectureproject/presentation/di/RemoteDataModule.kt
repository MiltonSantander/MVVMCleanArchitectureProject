package com.example.mvvmcleanarchitectureproject.presentation.di

import com.example.mvvmcleanarchitectureproject.data.api.TMDBApi
import com.example.mvvmcleanarchitectureproject.data.repository.artist.datasource.ArtistRemoteDataSource
import com.example.mvvmcleanarchitectureproject.data.repository.artist.datasourceimplementation.ArtistRemoteDataSourceImplementation
import com.example.mvvmcleanarchitectureproject.data.repository.movie.datasource.MovieRemoteDataSource
import com.example.mvvmcleanarchitectureproject.data.repository.movie.datasourceimplementation.MovieRemoteDataSourceImplementation
import com.example.mvvmcleanarchitectureproject.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.example.mvvmcleanarchitectureproject.data.repository.tvshow.datasourceimplementation.TvShowRemoteDataSourceImplementation
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey: String) {
    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbApi: TMDBApi): MovieRemoteDataSource {
        return MovieRemoteDataSourceImplementation(tmdbApi, apiKey)
    }

    @Singleton
    @Provides
    fun provideArtistRemoteDataSource(tmdbApi: TMDBApi): ArtistRemoteDataSource {
        return ArtistRemoteDataSourceImplementation(tmdbApi, apiKey)
    }

    @Singleton
    @Provides
    fun provideTvShowRemoteDataSource(tmdbApi: TMDBApi): TvShowRemoteDataSource {
        return TvShowRemoteDataSourceImplementation(tmdbApi, apiKey)
    }
}