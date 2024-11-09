package com.example.projeto.API

import com.example.projeto.room.entities.Dia
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Query

interface DiaAPI {
    @GET("getDias")
    fun getDias(): Call<List<Dia>>

    @GET("getDia")
    fun getDiaById(
        @Query("data") data: String,
        @Query("userId") userId: Int
    ): Call<Dia?>

    @POST("addDia")
    fun createDia(
        @Body dia: Dia
    ): Call<Dia>

    @PUT("updateDia")
    fun updateDia(
        @Body dia: Dia
    ): Call<Dia>

    @DELETE("deleteDia")
    fun deleteDia(
        @Query("data") data: String,
        @Query("userId") userId: Int
    ): Call<Unit>
}
