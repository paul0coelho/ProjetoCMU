package com.example.projeto.room

import androidx.room.Database
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
@TypeConverters
abstract class AppDatabase : RoomDatabase() {
    abstract fun utilizadorDao(): UtilizadorDao
    abstract fun livroDao(): LivroDao
    abstract fun exercicioDao(): ExercicioDao
    abstract fun alimentoDao(): AlimentoDao
    abstract fun diaDao(): DiaDao
    abstract fun alimentoUtilizadorDao(): AlimentoUtilizadorDao
    abstract fun livroUtilizadorDao(): LivroUtilizadorDao
    abstract fun exercicioUtilizadorDao(): ExercicioUtilizadorDao
}
