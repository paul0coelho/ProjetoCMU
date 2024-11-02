package com.example.projeto.room.dao

import androidx.room.*
import com.example.projeto.room.entities.LivroUtilizador

@Dao
interface LivroUtilizadorDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(livroUtilizador: LivroUtilizador)

    @Delete
    suspend fun delete(livroUtilizador: LivroUtilizador)

    @Query("SELECT * FROM Livro_Utilizador WHERE Id_Utilizador = :userId")
    suspend fun getByUserId(userId: Int): List<LivroUtilizador>

    @Query("SELECT * FROM Livro_Utilizador WHERE id_Livro = :livroId")
    suspend fun getByLivroId(livroId: Int): List<LivroUtilizador>
}
