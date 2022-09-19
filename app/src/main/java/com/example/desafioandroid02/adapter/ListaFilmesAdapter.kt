package com.example.desafioandroid02.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.Glide.init
import com.example.desafioandroid02.databinding.ItemFilmeBinding
import com.example.desafioandroid02.webclient.model.Filme

class ListaFilmesAdapter(): RecyclerView.Adapter<ListaFilmesAdapter.ViewHolder>() {

    private val listaFilmes: ArrayList<Filme> = arrayListOf()
    private lateinit var mListener: onItemClickListener

    class ViewHolder(
        private val binding: ItemFilmeBinding, listener: onItemClickListener
    ): RecyclerView.ViewHolder(binding.root){
        fun bind(filme: Filme){
            val img = ("https://image.tmdb.org/t/p/w500${filme.bannerImagem}")
            Glide.with(binding.root).load(img).into(binding.itemFilmeImagem)
            binding.itemFilmeNome.text = filme.titulo
        }
        init {
            itemView.setOnClickListener{
                listener.onItemClick(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder{
        return ViewHolder(ItemFilmeBinding.inflate(LayoutInflater.from(parent.context), parent, false), mListener)
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

        listaFilmes.clear()
        listaFilmes.addAll(listaMandaAdapter)

        notifyItemRangeInserted(oldRangeItem, newRangeItem)
    }

    interface onItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener){
        mListener = listener
    }

}