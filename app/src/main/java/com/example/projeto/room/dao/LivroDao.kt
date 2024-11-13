package com.example.projeto.room.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.projeto.room.entities.Livro

@Dao
interface LivroDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(livro: Livro)

    @Update
    suspend fun update(livro: Livro)

    @Delete
    suspend fun delete(livro: Livro)

    @Query("SELECT * FROM Livro WHERE id = :id")
    fun getById(id: Int): Livro?

    @Query("SELECT * FROM Livro")
    fun getAll(): LiveData<List<Livro>>
}
