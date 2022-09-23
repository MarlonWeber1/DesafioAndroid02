package com.example.desafioandroid02.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Filme(
        @SerializedName("id") val id: Int,
        @SerializedName("title") val titulo: String,
        @SerializedName("overview") val descricao: String,
        @SerializedName("release_date") val dataDeLancamento: String,
        @SerializedName("poster_path") val posterImagem: String,
        @SerializedName("backdrop_path") val bannerImagem: String
):Serializable{
    val filme: Filme
    get() = Filme(
        id?: 0,
        titulo?: "",
        descricao?: "",
        dataDeLancamento?: "",
        posterImagem?: "",
        bannerImagem?: ""
    )
}