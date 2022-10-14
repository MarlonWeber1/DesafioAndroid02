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
import com.example.desafioandroid02.databinding.ActivityListaFilmesBinding
import com.example.desafioandroid02.model.Filme

class FilmesFavoritos : AppCompatActivity() {

    private val binding by lazy {
        ActivityListaFilmesBinding.inflate(layoutInflater)
    }
    private lateinit var dao: FilmeFavoritoDAO
    private var arrayList: ArrayList<Filme> = ArrayList()
    private lateinit var recycler: RecyclerView
    private val teste by lazy{
        ListaFilmesAdapter();
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filmes_favoritos)

        dao = FilmesDatabase.getInstance(this).getFilmeFavoritoDAO()

        recycler = binding.activityListaNotasRecyclerview
        recycler.adapter = teste
        arrayList = dao.busca() as ArrayList<Filme>
        teste.mandaProAdapter(dao.busca())

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