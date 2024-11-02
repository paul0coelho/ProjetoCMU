package com.example.projeto.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Alimento")
data class Alimento(
    @PrimaryKey val id: Int,
    val nome: String,
    val calorias: Float,
    val quantidadeUnitaria: Float,
    val unidade: String,
    val alcool: Boolean
)
