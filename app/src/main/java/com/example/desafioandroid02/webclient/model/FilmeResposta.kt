package com.example.desafioandroid02.webclient.model

import com.example.desafioandroid02.model.Filme

data class FilmeResposta (
    val page : Int?,
    val results : List<Filme>?,
    val total_pages: Int?,
    val total_results: Int?
)