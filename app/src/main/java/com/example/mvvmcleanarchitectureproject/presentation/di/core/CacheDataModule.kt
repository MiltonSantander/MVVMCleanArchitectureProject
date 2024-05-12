package com.example.mvvmcleanarchitectureproject.presentation.di.core

import com.example.mvvmcleanarchitectureproject.data.repository.artist.datasource.ArtistCacheDataSource
import com.example.mvvmcleanarchitectureproject.data.repository.artist.datasourceimplementation.ArtistCacheDataSourceImplementation
import com.example.mvvmcleanarchitectureproject.data.repository.movie.datasource.MovieCacheDataSource
import com.example.mvvmcleanarchitectureproject.data.repository.movie.datasourceimplementation.MovieCacheDataSourceImplementation
import com.example.mvvmcleanarchitectureproject.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.example.mvvmcleanarchitectureproject.data.repository.tvshow.datasourceimplementation.TvShowCacheDataSourceImplementation
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {
    @Singleton
    @Provides
    fun provideMovieCacheDataSource(): MovieCacheDataSource {
        return MovieCacheDataSourceImplementation()
    }

    @Singleton
    @Provides
    fun provideArtistCacheDataSource(): ArtistCacheDataSource {
        return ArtistCacheDataSourceImplementation()
    }

    @Singleton
    @Provides
    fun provideTvShowCacheDataSource(): TvShowCacheDataSource {
        return TvShowCacheDataSourceImplementation()
    }
}