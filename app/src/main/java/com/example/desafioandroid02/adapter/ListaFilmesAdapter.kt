package com.example.desafioandroid02.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.desafioandroid02.Filme
import com.example.desafioandroid02.databinding.ItemFilmeBinding

class ListaFilmesAdapter(
    private val context: Context,
    filmes: List<Filme> = emptyList()
): RecyclerView.Adapter<ListaFilmesAdapter.ViewHolder>() {

    private val filmes = filmes.toMutableList()

    class ViewHolder(
        private val binding: ItemFilmeBinding
    ): RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        ItemFilmeBinding.inflate(LayoutInflater.from(context))
    )


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int = filmes.size
}