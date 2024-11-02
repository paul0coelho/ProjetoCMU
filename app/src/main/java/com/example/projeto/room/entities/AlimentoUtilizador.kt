package com.example.projeto.room.entities

import androidx.room.Entity
import java.util.Date

@Entity(tableName = "Alimento_Utilizador", primaryKeys = ["id_Alimento", "id_Utilizador", "data"])
data class AlimentoUtilizador(
    val id_Alimento: Int,
    val id_Utilizador: Int,
    val quantidade: Float,
    val data: Date
)
