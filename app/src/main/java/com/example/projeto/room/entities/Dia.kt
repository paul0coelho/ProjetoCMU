package com.example.projeto.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "Dia", primaryKeys = ["data", "idUser"])
data class Dia(
    val data: Date,
    val idUser: Int,
    val calorias: Int,
    val agua: Float,
    val paginasLidas: Int?,
    val alcool: Boolean,
    val treinoIndoor: Boolean,
    val treinoOutdoor: Boolean
)
