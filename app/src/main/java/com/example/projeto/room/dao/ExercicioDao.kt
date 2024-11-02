package com.example.projeto.room.dao

import androidx.room.*
import com.example.projeto.room.entities.Exercicio

@Dao
interface ExercicioDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(exercicio: Exercicio)

    @Update
    suspend fun update(exercicio: Exercicio)

    @Delete
    suspend fun delete(exercicio: Exercicio)

    @Query("SELECT * FROM Exercicio WHERE id = :id and tipo = 'indoor' ")
    suspend fun getIndoorById(id: Int): Exercicio?

    @Query("SELECT * FROM Exercicio WHERE id = :id and tipo = 'outdoor' ")
    suspend fun getOutdoorById(id: Int): Exercicio?

    @Query("SELECT * FROM Exercicio WHERE tipo = 'indoor'")
    suspend fun getAllIndoor(): List<Exercicio>

    @Query("SELECT * FROM Exercicio WHERE tipo = 'outdoor'")
    suspend fun getAllOutdoor(): List<Exercicio>
}
