package com.example.projeto.API

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    fun getInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://platform.fatsecret.com/rest/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}
