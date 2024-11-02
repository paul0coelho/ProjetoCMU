package com.example.projeto.room.entities

import androidx.room.Entity
import java.util.Date

@Entity(tableName = "Livro_Utilizador", primaryKeys = ["id_Livro", "id_Utilizador", "data"])
data class LivroUtilizador(
    val id_Livro: Int,
    val id_Utilizador: Int,
    val paginasLidas: Int,
    val data: Date
)
