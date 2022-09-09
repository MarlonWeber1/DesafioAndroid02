package com.example.desafioandroid02.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.desafioandroid02.model.Filme
import com.example.desafioandroid02.databinding.ItemFilmeBinding

class ListaFilmesAdapter(
    private val context: Context,
): RecyclerView.Adapter<ListaFilmesAdapter.ViewHolder>() {

    private val listaFilmes: ArrayList<Filme> = arrayListOf()

    class ViewHolder(
        private val binding: ItemFilmeBinding
    ): RecyclerView.ViewHolder(binding.root){
        fun bind(filme: Filme){
            val img = ("https://image.tmdb.org/t/p/w500 ${filme.bannerImagem}")
            Glide.with(binding.root).load(img).into(binding.itemFilmeImagem)
            binding.itemFilmeNome.text = filme.titulo
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder{
        return ViewHolder(ItemFilmeBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listaFilmes[position])
    }

    override fun getItemCount(): Int {
        return listaFilmes.size
    }

    fun mandaProAdapter(listaMandaAdapter: List<Filme>){
        val oldRangeItem = listaFilmes.size
        val newRangeItem = listaMandaAdapter.size

        notifyItemRangeInserted(oldRangeItem, newRangeItem)
    }
}