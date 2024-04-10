package com.example.mvvmcleanarchitectureproject.presentation.di

import android.content.Context
import androidx.room.Room
import com.example.mvvmcleanarchitectureproject.data.db.ArtistDAO
import com.example.mvvmcleanarchitectureproject.data.db.MovieDAO
import com.example.mvvmcleanarchitectureproject.data.db.TMDBDatabase
import com.example.mvvmcleanarchitectureproject.data.db.TvShowDAO
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Singleton
    @Provides
    fun getInstanceMovieDatabase(context: Context): TMDBDatabase {
        return Room.databaseBuilder(context, TMDBDatabase::class.java, "tmdbclient").build()
    }

    @Singleton
    @Provides
    fun getMovieDao(tmdbDatabase: TMDBDatabase): MovieDAO {
        return tmdbDatabase.movieDAO
    }

    @Singleton
    @Provides
    fun getArtistDao(tmdbDatabase: TMDBDatabase): ArtistDAO {
        return tmdbDatabase.artistDAO
    }

    @Singleton
    @Provides
    fun getTvShowDao(tmdbDatabase: TMDBDatabase): TvShowDAO {
        return tmdbDatabase.tvShowDAO
    }
}