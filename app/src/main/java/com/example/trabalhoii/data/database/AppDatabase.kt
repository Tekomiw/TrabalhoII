package com.example.trabalhoii.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.trabalhoii.data.dao.AlunoDao
import com.example.trabalhoii.data.dao.ExercicioDao
import com.example.trabalhoii.data.dao.TreinoDao
import com.example.trabalhoii.data.model.Aluno
import com.example.trabalhoii.data.model.Exercicio
import com.example.trabalhoii.data.model.Treino

@Database(entities = [Aluno::class, Treino::class, Exercicio::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun alunoDao(): AlunoDao
    abstract fun exercicioDao(): ExercicioDao
    abstract fun treinoDao(): TreinoDao
}