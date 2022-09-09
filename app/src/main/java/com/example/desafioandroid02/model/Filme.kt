package com.example.desafioandroid02.model

import com.google.gson.annotations.SerializedName

data class Filme (
    @SerializedName("id") val id: Int,
    @SerializedName("title") val titulo: String,
    @SerializedName("release_date") val dataDeLancamento: String,
    @SerializedName("poster_path") val bannerImagem: String,
)
