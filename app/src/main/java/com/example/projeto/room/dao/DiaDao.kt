package com.example.projeto.room.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.projeto.room.entities.Dia

@Dao
interface DiaDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(dia: Dia)

    @Update
    suspend fun update(dia: Dia)

    @Delete
    suspend fun delete(dia: Dia)

    @Query("SELECT * FROM Dia WHERE data = :data AND idUser = :userId")
    fun getById(data: String, userId: Int): Dia?

    @Query("SELECT * FROM Dia")
    fun getAll(): LiveData<List<Dia>>
}

