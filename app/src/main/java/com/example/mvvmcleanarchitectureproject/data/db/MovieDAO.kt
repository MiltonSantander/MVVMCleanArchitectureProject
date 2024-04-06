package com.example.mvvmcleanarchitectureproject.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mvvmcleanarchitectureproject.data.model.movie.Movie

@Dao
interface MovieDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovieList(movie: List<Movie>)

    @Query("SELECT * FROM popular_movie")
    suspend fun getMovieList(): List<Movie>

    @Query("DELETE FROM popular_movie")
    suspend fun deleteMovieList()
}