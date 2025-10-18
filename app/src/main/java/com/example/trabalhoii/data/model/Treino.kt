package com.example.trabalhoii.data.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "treino",
    foreignKeys = [ForeignKey(
        entity = Aluno::class,
        parentColumns = ["id"],
        childColumns = ["alunoId"],
        onDelete = ForeignKey.CASCADE
        )],
    indices = [Index(value = ["alunoId"])]
)
data class Treino(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val nome: String,
    val objetivo: String,
    val alunoId: Int
)
