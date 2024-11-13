package com.example.projeto.room.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.projeto.room.entities.LivroUtilizador

@Dao
interface LivroUtilizadorDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(livroUtilizador: LivroUtilizador)

    @Delete
    suspend fun delete(livroUtilizador: LivroUtilizador)

    @Query("SELECT * FROM Livro_Utilizador WHERE Id_Utilizador = :userId")
    fun getByUserId(userId: Int): LiveData<List<LivroUtilizador>>

    @Query("SELECT * FROM Livro_Utilizador WHERE id_Livro = :livroId")
    fun getByLivroId(livroId: Int): LiveData<List<LivroUtilizador>>
}
