package com.example.desafioandroid02

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.desafioandroid02.adapter.ListaFilmesAdapter
import com.example.desafioandroid02.databinding.ActivityListaFilmesBinding
import com.example.desafioandroid02.webclient.RetrofitInicializador
import java.lang.Exception

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

        lifecycleScope.launchWhenCreated {
            lifecycle.repeatOnLifecycle(Lifecycle.State.RESUMED){
                try {
                    val response = RetrofitInicializador().api.bucasFilmesPopulares()
                    if(response.isSuccessful){
                        adapter.mandaProAdapter(response.body()?.results?: emptyList())
                    }
                }catch(e:Exception) {
                    Toast.makeText(this@ListaFilmesActivity, "Error Sem Internet", Toast.LENGTH_SHORT).show()
                }
                binding.activityListaNotasRecyclerview.adapter = adapter
                adapter.setOnItemClickListener(object: ListaFilmesAdapter.onItemClickListener{
                    override fun onItemClick(position: Int) {
                        Toast.makeText(this@ListaFilmesActivity, "Item Clicado $position", Toast.LENGTH_SHORT).show()
                    }
                })
            }
        }



    }
}