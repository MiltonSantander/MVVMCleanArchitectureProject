package com.example.mvvmcleanarchitectureproject.data.model.artist


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "popular_artist")
data class Artist(
    @PrimaryKey
    @SerializedName("id")
    val id: Int?,
    @SerializedName("name")
    var name: String = "",
    @SerializedName("popularity")
    val popularity: Double?,
    @SerializedName("profile_path")
    var profilePath: String = ""
)