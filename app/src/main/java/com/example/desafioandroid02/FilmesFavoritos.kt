package com.example.desafioandroid02

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.desafioandroid02.adapter.ListaFilmesAdapter
import com.example.desafioandroid02.dao.FilmeFavoritoDAO
import com.example.desafioandroid02.database.FilmesDatabase
import com.example.desafioandroid02.databinding.ActivityFilmesFavoritosBinding
import com.example.desafioandroid02.databinding.ActivityListaFilmesBinding
import com.example.desafioandroid02.model.Filme

class FilmesFavoritos : AppCompatActivity() {

    private lateinit var binding: ActivityFilmesFavoritosBinding
    private lateinit var dao: FilmeFavoritoDAO
    private var arrayList: ArrayList<Filme> = ArrayList()
    private lateinit var recycler: RecyclerView
    private val teste by lazy{
        ListaFilmesAdapter();
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFilmesFavoritosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dao = FilmesDatabase.getInstance(this).getFilmeFavoritoDAO()

        recycler = binding.activityListaFavoritosRecyclerview
        recycler.adapter = teste
        arrayList = dao.busca() as? ArrayList<Filme> ?: arrayListOf()
        teste.mandaProAdapter(arrayList)

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

        fun teste(){
            binding.root.setOnLongClickListener {
                false
            }
            binding.root.setOnClickListener {

            }
        }
    }

}