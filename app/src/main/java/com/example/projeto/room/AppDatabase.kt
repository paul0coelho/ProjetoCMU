package com.example.projeto.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.projeto.room.dao.*
import com.example.projeto.room.entities.*

@Database(
    entities = [
        Utilizador::class,
        Livro::class,
        Exercicio::class,
        Alimento::class,
        Dia::class,
        AlimentoUtilizador::class,
        LivroUtilizador::class,
        ExercicioUtilizador::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(DateConverters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun utilizadorDao(): UtilizadorDao
    abstract fun livroDao(): LivroDao
    abstract fun exercicioDao(): ExercicioDao
    abstract fun alimentoDao(): AlimentoDao
    abstract fun diaDao(): DiaDao
    abstract fun alimentoUtilizadorDao(): AlimentoUtilizadorDao
    abstract fun livroUtilizadorDao(): LivroUtilizadorDao
    abstract fun exercicioUtilizadorDao(): ExercicioUtilizadorDao

    companion object {
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "75database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}
