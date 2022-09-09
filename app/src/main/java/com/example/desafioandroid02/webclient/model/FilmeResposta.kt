package com.example.desafioandroid02.webclient.model

data class FilmeResposta (
    val page : Int?,
    val results : List<Filme>?,
    val total_pages: Int?,
    val total_results: Int?
)

data class Filme(
    val id: Int?,
    val title: String?,
    val poster_path: String?,
    val backdrop_path: String?
)