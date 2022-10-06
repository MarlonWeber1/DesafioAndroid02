package com.example.desafioandroid02

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.desafioandroid02.adapter.ListaFilmesAdapter
import com.example.desafioandroid02.databinding.ActivityListaFilmesBinding
import com.example.desafioandroid02.webclient.RetrofitInicializador
import java.io.Serializable

class ListaFilmesActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityListaFilmesBinding.inflate(layoutInflater)
    }

    private val adapter by lazy {
        ListaFilmesAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setTitle("Lista Filmes")

        lifecycleScope.launchWhenCreated {
            lifecycle.repeatOnLifecycle(Lifecycle.State.CREATED){
                try {
                    val response = RetrofitInicializador().api.bucasFilmesPopulares()
                    if(response.isSuccessful){
                        adapter.mandaProAdapter(response.body()?.results?: emptyList())
                    }
                }catch(e:Exception) {
                    Toast.makeText(this@ListaFilmesActivity, "Error Sem Internet", Toast.LENGTH_SHORT).show()
                }
                binding.activityListaNotasRecyclerview.adapter = adapter
                adapter.itemClickListener = {
                    val intent = Intent(this@ListaFilmesActivity, TelaInfoFilmeActivity::class.java)
                    intent.putExtra("filme", it as Serializable)
                    startActivity(intent)
                }
            }
        }

        binding.bottomNav.setOnItemSelectedListener {
            when(it.itemId){
                R.id.menuFilmes->{
                    val intent = Intent(this@ListaFilmesActivity, ListaFilmesActivity::class.java)
                    startActivity(intent)
                }
                R.id.menuFavoritos->{
                    val intent = Intent(this@ListaFilmesActivity, FilmesFavoritos::class.java)
                    startActivity(intent)
                }
            }
            true
        }

    }
}
