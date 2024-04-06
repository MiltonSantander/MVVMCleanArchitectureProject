package com.example.mvvmcleanarchitectureproject.data.model.artist


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "popular_artist")
data class Artist(
    @SerializedName("adult")
    val adult: Boolean?,
    @SerializedName("gender")
    val gender: Int?,
    @PrimaryKey
    @SerializedName("id")
    val id: Int?,
    @SerializedName("known_for_department")
    val knownForDepartment: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("original_name")
    val originalName: String?,
    @SerializedName("popularity")
    val popularity: Double?,
    @SerializedName("profile_path")
    val profilePath: String?
)