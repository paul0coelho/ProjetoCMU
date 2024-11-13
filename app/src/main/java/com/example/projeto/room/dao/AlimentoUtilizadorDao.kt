package com.example.projeto.room.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.projeto.room.entities.AlimentoUtilizador

@Dao
interface AlimentoUtilizadorDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(alimentoUtilizador: AlimentoUtilizador)

    @Delete
    suspend fun delete(alimentoUtilizador: AlimentoUtilizador)

    @Query("SELECT * FROM Alimento_Utilizador WHERE id_Utilizador = :userId")
    fun getByUserId(userId: Int): LiveData<List<AlimentoUtilizador>>

    @Query("SELECT * FROM Alimento_Utilizador WHERE id_Alimento = :alimentoId")
    fun getByAlimentoId(alimentoId: Int): LiveData<List<AlimentoUtilizador>>
}
