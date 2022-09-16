package com.example.desafioandroid02.webclient.model

import com.google.gson.annotations.SerializedName

data class FilmeResposta (
    val page : Int?,
    val results : List<Filme>?,
    val total_pages: Int?,
    val total_results: Int?
)

data class Filme(
    @SerializedName("id") val id: Int,
    @SerializedName("title") val titulo: String,
    @SerializedName("release_date") val dataDeLancamento: String,
    @SerializedName("poster_path") val bannerImagem: String,
)