package com.example.desafioandroid02.webclient

import com.example.desafioandroid02.webclient.services.FilmeService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInicializador {

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/3/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val api = retrofit.create(FilmeService::class.java)



}