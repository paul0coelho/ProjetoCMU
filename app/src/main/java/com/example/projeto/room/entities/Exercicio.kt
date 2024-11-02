package com.example.projeto.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Exercicio")
data class Exercicio(
    @PrimaryKey val id: Int,
    val nome: String,
    val tipo: String,
    val descricao: String
)
