package com.example.projeto.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Livro")
data class Livro(
    @PrimaryKey val id: Int,
    val nome: String,
    val autor: String,
    val categoria: String,
    val numeroPaginas: Int
)
