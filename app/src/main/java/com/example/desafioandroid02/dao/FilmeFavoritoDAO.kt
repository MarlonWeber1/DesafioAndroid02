package com.example.desafioandroid02.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.example.desafioandroid02.model.Filme

@Dao
interface FilmeFavoritoDAO {
    @Insert(onConflict = REPLACE)
    fun salva (vararg filme: Filme)

    @Query("SELECT * FROM Filme")
    fun busca(): List<Filme>?

}