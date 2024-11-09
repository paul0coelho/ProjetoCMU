package com.example.projeto.API

import com.example.projeto.room.entities.Livro
import com.example.projeto.room.entities.LivroUtilizador
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Query

interface LivroAPI {
    @GET("getLivros")
    fun getLivros(): Call<List<Livro>>

    @GET("getLivro")
    fun getLivroById(
        @Query("id") id: Int
    ): Call<Livro?>

    @POST("addLivro")
    fun createLivro(
        @Body livro: Livro
    ): Call<Livro>

    @PUT("updateLivro")
    fun updateLivro(
        @Body livro: Livro
    ): Call<Livro>

    @DELETE("deleteLivro")
    fun deleteLivro(
        @Query("id") id: Int
    ): Call<Unit>

    @POST("addLivroUtilizador")
    fun addLivroUtilizador(
        @Body livroUtilizador: LivroUtilizador
    ): Call<LivroUtilizador>

    @DELETE("deleteLivroUtilizador")
    fun deleteLivroUtilizador(
        @Query("idUtilizador") idUtilizador: Int,
        @Query("idLivro") idLivro: Int
    ): Call<Unit>

    @GET("getLivroUtilizadoresByUserId")
    fun getLivroUtilizadoresByUserId(
        @Query("userId") userId: Int
    ): Call<List<LivroUtilizador>>

    @GET("getLivroUtilizadoresByLivroId")
    fun getLivroUtilizadoresByLivroId(
        @Query("livroId") livroId: Int
    ): Call<List<LivroUtilizador>>
}
