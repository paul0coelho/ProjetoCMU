package com.example.projeto.room.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.projeto.room.entities.ExercicioUtilizador

@Dao
interface ExercicioUtilizadorDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(exercicioUtilizador: ExercicioUtilizador)

    @Delete
    suspend fun delete(exercicioUtilizador: ExercicioUtilizador)

    @Query("SELECT * FROM Exercicio_Utilizador WHERE Id_Utilizador = :userId")
    fun getByUserId(userId: Int): LiveData<List<ExercicioUtilizador>>

    @Query("SELECT * FROM Exercicio_Utilizador WHERE id_Exercicio = :exercicioId")
    fun getByExercicioId(exercicioId: Int): LiveData<List<ExercicioUtilizador>>
}

