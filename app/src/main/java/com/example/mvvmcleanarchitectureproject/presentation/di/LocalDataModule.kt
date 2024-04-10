package com.example.mvvmcleanarchitectureproject.presentation.di

import com.example.mvvmcleanarchitectureproject.data.db.ArtistDAO
import com.example.mvvmcleanarchitectureproject.data.db.MovieDAO
import com.example.mvvmcleanarchitectureproject.data.db.TvShowDAO
import com.example.mvvmcleanarchitectureproject.data.repository.artist.datasource.ArtistLocalDataSource
import com.example.mvvmcleanarchitectureproject.data.repository.artist.datasourceimplementation.ArtistLocalDataSourceImplementation
import com.example.mvvmcleanarchitectureproject.data.repository.movie.datasource.MovieLocalDataSource
import com.example.mvvmcleanarchitectureproject.data.repository.movie.datasourceimplementation.MovieLocalDataSourceImplementation
import com.example.mvvmcleanarchitectureproject.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.example.mvvmcleanarchitectureproject.data.repository.tvshow.datasourceimplementation.TvShowLocalDataSourceImplementation
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {
    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDao: MovieDAO): MovieLocalDataSource {
        return MovieLocalDataSourceImplementation(movieDao)
    }

    @Singleton
    @Provides
    fun provideArtistLocalDataSource(artistDao: ArtistDAO): ArtistLocalDataSource {
        return ArtistLocalDataSourceImplementation(artistDao)
    }

    @Singleton
    @Provides
    fun provideTvShowLocalDataSource(tvShowDao: TvShowDAO): TvShowLocalDataSource {
        return TvShowLocalDataSourceImplementation(tvShowDao)
    }
}