package com.example.trabalhoii.data.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "exercicio",
    foreignKeys = [ForeignKey(
        entity = Treino::class,
        parentColumns = ["id"],
        childColumns = ["treinoId"])],
    indices = [Index(value = ["treinoId"])])
data class Exercicio (
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val nome: String,
    val grupoMuscular: String,
    val treinoId: Int
)