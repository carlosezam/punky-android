package com.example.punky.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.punky.data.local.daos.BeerDao
import com.example.punky.data.local.daos.RemoteBeerKeysDao
import com.example.punky.data.local.entities.Beer
import com.example.punky.data.local.entities.RemoteBeerKeys

@Database(
    version = 2,
    entities = [
        Beer::class,
        RemoteBeerKeys::class
    ]
)
@TypeConverters(Converters::class)
abstract class PunkyDatabase : RoomDatabase() {

    abstract fun beerDao(): BeerDao
    abstract fun remoteBeerKeysDao(): RemoteBeerKeysDao

    companion object {

        @Volatile private var instance: PunkyDatabase? = null

        const val DATABASE_NAME = "punky_db"

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext, PunkyDatabase::class.java, DATABASE_NAME)
                    .fallbackToDestructiveMigration()
                    .build()

        fun getInstance(context: Context) = instance ?: synchronized(this){
            instance ?: buildDatabase(context).also { instance = it }
        }
    }
}