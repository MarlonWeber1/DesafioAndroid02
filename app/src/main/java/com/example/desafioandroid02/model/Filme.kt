package com.example.desafioandroid02.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity
data class Filme(
        @PrimaryKey(autoGenerate = false)
        @ColumnInfo(name = "id")
        @SerializedName("id") val id: Int,
        @ColumnInfo(name = "title")
        @SerializedName("title") val titulo: String,
        @ColumnInfo(name = "overview")
        @SerializedName("overview") val descricao: String,
        @ColumnInfo(name = "release_date")
        @SerializedName("release_date") val dataDeLancamento: String,
        @ColumnInfo(name = "poster_path")
        @SerializedName("poster_path") val posterImagem: String,
        @ColumnInfo(name = "backdrop_path")
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