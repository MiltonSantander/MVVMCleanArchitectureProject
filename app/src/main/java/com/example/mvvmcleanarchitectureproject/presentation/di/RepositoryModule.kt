package com.example.mvvmcleanarchitectureproject.presentation.di

import com.example.mvvmcleanarchitectureproject.data.repository.artist.ArtistRepositoryImplementation
import com.example.mvvmcleanarchitectureproject.data.repository.artist.datasource.ArtistCacheDataSource
import com.example.mvvmcleanarchitectureproject.data.repository.artist.datasource.ArtistLocalDataSource
import com.example.mvvmcleanarchitectureproject.data.repository.artist.datasource.ArtistRemoteDataSource
import com.example.mvvmcleanarchitectureproject.data.repository.movie.MovieRepositoryImplementation
import com.example.mvvmcleanarchitectureproject.data.repository.movie.datasource.MovieCacheDataSource
import com.example.mvvmcleanarchitectureproject.data.repository.movie.datasource.MovieLocalDataSource
import com.example.mvvmcleanarchitectureproject.data.repository.movie.datasource.MovieRemoteDataSource
import com.example.mvvmcleanarchitectureproject.data.repository.tvshow.TvShowRepositoryImplementation
import com.example.mvvmcleanarchitectureproject.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.example.mvvmcleanarchitectureproject.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.example.mvvmcleanarchitectureproject.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.example.mvvmcleanarchitectureproject.domain.repository.ArtistRepository
import com.example.mvvmcleanarchitectureproject.domain.repository.MovieRepository
import com.example.mvvmcleanarchitectureproject.domain.repository.TvShowRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {
    @Singleton
    @Provides
    fun provideMovieRepository(
        movieRemoteDataSource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource
    ): MovieRepository {
        return MovieRepositoryImplementation(
            movieRemoteDataSource,
            movieLocalDataSource,
            movieCacheDataSource
        )
    }

    @Singleton
    @Provides
    fun provideArtistRepository(
        artistRemoteDataSource: ArtistRemoteDataSource,
        artistLocalDataSource: ArtistLocalDataSource,
        artistCacheDataSource: ArtistCacheDataSource
    ): ArtistRepository {
        return ArtistRepositoryImplementation(
            artistRemoteDataSource,
            artistLocalDataSource,
            artistCacheDataSource
        )
    }

    @Singleton
    @Provides
    fun provideTvShowRepository(
        tvShowRemoteDataSource: TvShowRemoteDataSource,
        tvShowLocalDataSource: TvShowLocalDataSource,
        tvShowCacheDataSource: TvShowCacheDataSource
    ): TvShowRepository {
        return TvShowRepositoryImplementation(
            tvShowRemoteDataSource,
            tvShowLocalDataSource,
            tvShowCacheDataSource
        )
    }
}