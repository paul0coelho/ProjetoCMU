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

}
