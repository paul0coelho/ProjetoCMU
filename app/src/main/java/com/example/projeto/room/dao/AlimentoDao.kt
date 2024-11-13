package com.example.projeto.room.dao

import androidx.lifecycle.LiveData
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
    fun getById(id: Int): Alimento?

    @Query("SELECT * FROM Alimento")
    fun getAll(): LiveData<List<Alimento>>
}
