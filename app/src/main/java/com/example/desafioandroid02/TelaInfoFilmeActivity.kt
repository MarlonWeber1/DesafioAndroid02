package com.example.desafioandroid02

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.example.desafioandroid02.dao.FilmeFavoritoDAO
import com.example.desafioandroid02.database.FilmesDatabase
import com.example.desafioandroid02.model.Filme
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.launch

class TelaInfoFilmeActivity : AppCompatActivity() {
    private lateinit var dao: FilmeFavoritoDAO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_info_filme)
        setTitle("Info Filmes")

        dao = FilmesDatabase.FilmesDatabase.getInstance(this).getFilmeFavoritoDAO()

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

        val favBotao = findViewById<FloatingActionButton>(R.id.botaoFilmeFavoritos)

        favBotao.setOnClickListener(View.OnClickListener {
            lifecycleScope.launch{
                dao.salva(filme)
                Toast.makeText(this@TelaInfoFilmeActivity, "Filme na tela de favoritos", Toast.LENGTH_SHORT).show()
            }
        })

    }
}