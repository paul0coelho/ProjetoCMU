package com.example.projeto.API

import com.example.projeto.room.entities.Exercicio
import com.example.projeto.room.entities.ExercicioUtilizador
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Query

interface ExercicioAPI {
    @GET("getExercicios")
    fun getExercicios(): Call<List<Exercicio>>

    @GET("getExercicio")
    fun getExercicioById(
        @Query("id") id: Int
    ): Call<Exercicio?>

    @POST("addExercicio")
    fun createExercicio(
        @Body exercicio: Exercicio
    ): Call<Exercicio>

    @PUT("updateExercicio")
    fun updateExercicio(
        @Body exercicio: Exercicio
    ): Call<Exercicio>

    @DELETE("deleteExercicio")
    fun deleteExercicio(
        @Query("id") id: Int
    ): Call<Unit>

    @POST("addExercicioUtilizador")
    fun addExercicioUtilizador(
        @Body exercicioUtilizador: ExercicioUtilizador
    ): Call<ExercicioUtilizador>

    @DELETE("deleteExercicioUtilizador")
    fun deleteExercicioUtilizador(
        @Query("idUtilizador") idUtilizador: Int,
        @Query("idExercicio") idExercicio: Int
    ): Call<Unit>

    @GET("getExercicioUtilizadoresByUserId")
    fun getExercicioUtilizadoresByUserId(
        @Query("userId") userId: Int
    ): Call<List<ExercicioUtilizador>>

    @GET("getExercicioUtilizadoresByExercicioId")
    fun getExercicioUtilizadoresByExercicioId(
        @Query("exercicioId") exercicioId: Int
    ): Call<List<ExercicioUtilizador>>
}
