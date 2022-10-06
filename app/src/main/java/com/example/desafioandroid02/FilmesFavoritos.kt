package com.example.desafioandroid02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.desafioandroid02.databinding.ActivityListaFilmesBinding

class FilmesFavoritos : AppCompatActivity() {

    private val binding by lazy {
        ActivityListaFilmesBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filmes_favoritos)

        binding.bottomNav.setOnItemSelectedListener {
            when(it.itemId){
                R.id.menuFilmes->{
                    val intent = Intent(this@FilmesFavoritos , ListaFilmesActivity::class.java)
                    startActivity(intent)
                }
                R.id.menuFavoritos->{
                    val intent = Intent(this@FilmesFavoritos, ListaFilmesActivity::class.java)
                    startActivity(intent)
                }
            }
            true
        }
    }
}