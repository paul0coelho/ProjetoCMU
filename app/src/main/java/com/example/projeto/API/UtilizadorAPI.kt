package com.example.projeto.API

import com.example.projeto.room.entities.Utilizador
import retrofit2.Call
import retrofit2.http.*

interface UtilizadorAPI {
    @GET("getUtilizadores")
    fun getUtilizadores(
    ): Call<List<Utilizador>>

    @GET("getUtilizador")
    fun getUtilizadorById(
        @Query("id") id: Int
    ): Call<Utilizador?>

    @POST("addUtilizador")
    fun createUtilizador(
        @Body utilizador: Utilizador
    ): Call<Utilizador>

    @PUT("updateUtilizador")
    fun updateUtilizador(
        @Query("id") id: Int,
        @Body utilizador: Utilizador
    ): Call<Utilizador>

    @DELETE("deleteUtilizador")
    fun deleteUtilizador(
        @Query("id") id: Int
    ): Call<Unit>
}
