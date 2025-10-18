package com.example.trabalhoii.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "aluno")
data class Aluno(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val nome: String,
    val idade: Int
)
