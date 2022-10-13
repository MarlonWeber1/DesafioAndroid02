package com.example.desafioandroid02

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.desafioandroid02.model.Filme

class TelaInfoFilmeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_info_filme)
        setTitle("Info Filmes")

        var filme = intent.getSerializableExtra("filme") as Filme
        val imagem = findViewById<ImageView>(R.id.bannerFilme)
        Glide.with(imagem).load("https://image.tmdb.org/t/p/w500${filme.bannerImagem}").into(imagem)
        val foto = findViewById<ImageView>(R.id.fotoFilme)
        Glide.with(foto).load("https://image.tmdb.org/t/p/w500${filme.posterImagem}").into(foto)
        val titulo = findViewById<TextView>(R.id.bindingNomeFilme)
        titulo.text = filme.titulo
        val dataLancamento = findViewById<TextView>(R.id.bindingDataLancamento)
        dataLancamento.text = filme.dataDeLancamento
        val descricao = findViewById<TextView>(R.id.bindingDescricao)
        descricao.text = filme.descricao

    }
}