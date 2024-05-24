package com.example.mvvmcleanarchitectureproject.data.model.tvshow


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "popular_tvshow")
data class TvShow(
    @PrimaryKey
    @SerializedName("id")
    val id: Int?,
    @SerializedName("name")
    var name: String = "",
    @SerializedName("overview")
    var overview: String = "",
    @SerializedName("popularity")
    val popularity: Double?,
    @SerializedName("poster_path")
    var posterPath: String = "",
)