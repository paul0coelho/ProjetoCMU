package com.example.projeto.room.entities

import androidx.room.Entity
import java.util.Date

@Entity(tableName = "Exercicio_Utilizador", primaryKeys = ["id_Exercicio", "id_Utilizador", "data"])
data class ExercicioUtilizador(
    val id_Exercicio: Int,
    val id_Utilizador: Int,
    val data: Date,
    val localInicial: String,
    val localFinal: String,
    val duracao: String
)
