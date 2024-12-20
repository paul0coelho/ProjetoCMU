package com.example.projeto.room.dao

import androidx.lifecycle.LiveData
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
    fun getIndoorById(id: Int): Exercicio?

    @Query("SELECT * FROM Exercicio WHERE id = :id and tipo = 'outdoor' ")
    fun getOutdoorById(id: Int): Exercicio?

    @Query("SELECT * FROM Exercicio WHERE tipo = 'indoor'")
    fun getAllIndoor(): LiveData<List<Exercicio>>

    @Query("SELECT * FROM Exercicio WHERE tipo = 'outdoor'")
    fun getAllOutdoor(): LiveData<List<Exercicio>>
}
