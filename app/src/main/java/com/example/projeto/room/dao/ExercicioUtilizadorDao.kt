package com.example.projeto.room.dao

import androidx.room.*
import com.example.projeto.room.entities.ExercicioUtilizador

@Dao
interface ExercicioUtilizadorDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(exercicioUtilizador: ExercicioUtilizador)

    @Delete
    suspend fun delete(exercicioUtilizador: ExercicioUtilizador)

    @Query("SELECT * FROM Exercicio_Utilizador WHERE Id_Utilizador = :userId")
    suspend fun getByUserId(userId: Int): List<ExercicioUtilizador>

    @Query("SELECT * FROM Exercicio_Utilizador WHERE id_Exercicio = :exercicioId")
    suspend fun getByExercicioId(exercicioId: Int): List<ExercicioUtilizador>
}

