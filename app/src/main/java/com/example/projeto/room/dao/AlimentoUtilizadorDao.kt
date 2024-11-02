package com.example.projeto.room.dao

import androidx.room.*
import com.example.projeto.room.entities.AlimentoUtilizador

@Dao
interface AlimentoUtilizadorDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(alimentoUtilizador: AlimentoUtilizador)

    @Delete
    suspend fun delete(alimentoUtilizador: AlimentoUtilizador)

    @Query("SELECT * FROM Alimento_Utilizador WHERE id_Utilizador = :userId")
    suspend fun getByUserId(userId: Int): List<AlimentoUtilizador>

    @Query("SELECT * FROM Alimento_Utilizador WHERE id_Alimento = :alimentoId")
    suspend fun getByAlimentoId(alimentoId: Int): List<AlimentoUtilizador>
}
