package com.example.desafioandroid02.webclient.services

import com.example.desafioandroid02.webclient.model.FilmeResposta
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface FilmeService {

    @GET("movie/popular")
    suspend fun bucasFilmesPopulares(
        @Query("api_key") chave:String="9106a44c761c36bbb02f24c16958a56a"
    ): Response<FilmeResposta>

}