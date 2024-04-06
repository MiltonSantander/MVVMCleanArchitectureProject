package com.example.mvvmcleanarchitectureproject.data


import com.google.gson.annotations.SerializedName

data class ArtistListResponse(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val artistList: List<Artist>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)