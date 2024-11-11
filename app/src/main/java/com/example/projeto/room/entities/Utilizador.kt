package com.example.projeto.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "Utilizador")
data class Utilizador(
    @PrimaryKey val id: Int,
    val nome: String,
    val email: String,
    val password: String,
    val genero: String,
    val data_nascimento: Date,
    val telemovel: Int?,
    val dataRegisto: Date,
    val dataInicio: Date?,
    val maximoStreak: Int?,
    val streakAtual: Int?
)
