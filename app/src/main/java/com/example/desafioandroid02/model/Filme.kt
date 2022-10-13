package com.example.desafioandroid02.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity
data class Filme(
        @PrimaryKey(autoGenerate = false)
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