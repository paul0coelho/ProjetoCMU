package com.example.projeto.room.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.projeto.room.entities.Utilizador

@Dao
interface UtilizadorDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(utilizador: Utilizador)

    @Update
    suspend fun update(utilizador: Utilizador)

    @Delete
    suspend fun delete(utilizador: Utilizador)

    @Query("SELECT * FROM Utilizador WHERE id = :id")
    fun getById(id: Int): Utilizador?

    @Query("SELECT * FROM Utilizador WHERE email = :email")
    fun getByEmail(email: String): Utilizador?

    @Query("SELECT * FROM Utilizador")
    fun getAll(): LiveData<List<Utilizador>>
}
