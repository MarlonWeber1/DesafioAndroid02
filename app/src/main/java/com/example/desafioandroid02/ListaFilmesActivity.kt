package com.example.desafioandroid02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Lifecycle
import com.example.desafioandroid02.adapter.ListaFilmesAdapter
import com.example.desafioandroid02.databinding.ActivityListaFilmesBinding
import kotlinx.coroutines.Dispatchers
import retrofit2.Call
import retrofit2.Response

class ListaFilmesActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityListaFilmesBinding.inflate(layoutInflater)
    }

    private val adapter by lazy {
        ListaFilmesAdapter(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_filmes)

        binding.activityListaNotasRecyclerview.adapter = adapter

    }
}