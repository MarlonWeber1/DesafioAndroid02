package com.example.desafioandroid02.adapter

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.desafioandroid02.Filme
import com.example.desafioandroid02.databinding.ItemFilmeBinding

class ListaFilmesAdapter(
    private val context: Context,
    var qndClicaFilme: (filme: Filme) -> Unit = {},
    filmes: List<Filme> = emptyList()
): RecyclerView.Adapter<ListaFilmesAdapter.ViewHolder>() {

    private val filmes = filmes.toMutableList()

    class ViewHolder(
        private val binding: ItemFilmeBinding,
        private val qndClicaFilme: (filme: Filme) -> Unit
    ): RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}