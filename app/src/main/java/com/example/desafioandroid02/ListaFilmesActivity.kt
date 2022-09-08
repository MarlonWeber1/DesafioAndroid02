package com.example.desafioandroid02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.desafioandroid02.adapter.ListaFilmesAdapter
import com.example.desafioandroid02.databinding.ActivityListaFilmesBinding

class ListaFilmesActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityListaFilmesBinding.inflate(layoutInflater)
    }

    private val adapter by lazy {
        ListaFilmesAdapter(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}