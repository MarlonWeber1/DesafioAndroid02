package com.example.desafioandroid02.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import com.example.desafioandroid02.dao.FilmeFavoritoDAO
import com.example.desafioandroid02.model.Filme

@Database(
    entities = [Filme::class],
    version = 1,
    exportSchema = false
)
abstract class FilmesDatabase : RoomDatabase(){
    abstract fun getFilmeFavoritoDAO(): FilmeFavoritoDAO

    companion object factory{
        private lateinit var db: FilmesDatabase

        fun getInstance(context: Context): FilmesDatabase{
            if(::db.isInitialized) return db
            db = databaseBuilder(context, FilmesDatabase::class.java, "listFavoritosDB").allowMainThreadQueries().build()
            return db
        }
    }
}