package com.example.desafioandroid02.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import com.example.desafioandroid02.dao.FilmeFavoritoDAO
import com.example.desafioandroid02.model.Filme

class FilmesDatabase {
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
                db = databaseBuilder(context, FilmesDatabase::class.java, "listFavoritosDB")
                    .addMigrations(Migration(1,2){
                        it.execSQL("DROP TABLE IF EXISTS 'Filme'")
                        it.execSQL(
                            "CREATE TABLE IF NOT EXISTS Filme (" +
                                    "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "+
                                    "title TEXT NOT NULL, "+
                                    "overview TEXT NOT NULL,"+
                                    "release_date TEXT NOT NULL,"+
                                    "poster_path TEXT NOT NULL," +
                                    "backdrop_path TEXT NOT NULL)"
                        );
                    }).allowMainThreadQueries().build()
                return db
            }
        }
    }
}