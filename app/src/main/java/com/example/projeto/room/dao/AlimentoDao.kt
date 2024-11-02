package com.example.projeto.room.dao

import androidx.room.*
import com.example.projeto.room.entities.Alimento

@Dao
interface AlimentoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(alimento: Alimento)

    @Update
    suspend fun update(alimento: Alimento)

    @Delete
    suspend fun delete(alimento: Alimento)

    @Query("SELECT * FROM Alimento WHERE id = :id")
    suspend fun getById(id: Int): Alimento?

    @Query("SELECT * FROM Alimento")
    suspend fun getAll(): List<Alimento>
}
