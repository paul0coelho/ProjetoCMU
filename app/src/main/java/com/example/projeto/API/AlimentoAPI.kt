package com.example.projeto.API

import com.example.projeto.room.entities.Alimento
import com.example.projeto.room.entities.AlimentoUtilizador
import com.example.projeto.room.entities.Utilizador
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Query

interface AlimentoAPI {
    @GET("getAlimentos")
    fun getAlimentos(): Call<List<Alimento>>

    @GET("getAlimento")
    fun getAlimentoById(
        @Query("id") id: Int)
    : Call<Alimento?>

    @POST("addAlimento")
    fun createAlimento(
        @Body utilizador: Utilizador
    )
    : Call<Alimento>

    @PUT("updateAlimento")
    fun updateAlimento(
        @Body utilizador: Utilizador
    )
    : Call<Alimento>

    @DELETE("deleteAlimento")
    fun deleteAlimento(
        @Query("id") id: Int)
    : Call<Unit>

    @POST("addAlimentoUtilizador")
    fun addAlimentoUtilizador(
        @Body alimentoUtilizador: AlimentoUtilizador)
    : Call<AlimentoUtilizador>

    @DELETE("deleteAlimentoUtilizador")
    fun deleteAlimentoUtilizador(
        @Query("idUtilizador") idUtilizador: Int,
        @Query("idAlimento") idAlimento: Int)
    : Call<Unit>

    @GET("getAlimentoUtilizadoresByUserId")
    fun getAlimentoUtilizadoresByUserId(
        @Query("userId") userId: Int)
    : Call<List<AlimentoUtilizador>>

    @GET("getAlimentoUtilizadoresByAlimentoId")
    fun getAlimentoUtilizadoresByAlimentoId(
        @Query("alimentoId") alimentoId: Int)
    : Call<List<AlimentoUtilizador>>
}
