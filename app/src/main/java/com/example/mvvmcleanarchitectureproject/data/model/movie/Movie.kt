package com.example.mvvmcleanarchitectureproject.data.model.movie


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "popular_movie")
data class Movie(
    @PrimaryKey
    @SerializedName("id")
    val id: Int?,
    @SerializedName("overview")
    var overview: String = "",
    @SerializedName("popularity")
    val popularity: Double?,
    @SerializedName("poster_path")
    var posterPath: String = "",
    @SerializedName("title")
    var title: String = "",
)