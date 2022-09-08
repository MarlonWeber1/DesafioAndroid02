package com.example.desafioandroid02

import androidx.room.Entity

@Entity
data class Filme (
    val id: Long = 0L,
    val titulo: String,
    val descricao: String,
    val imagem: String? = null
)