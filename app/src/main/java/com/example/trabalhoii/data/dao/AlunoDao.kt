package com.example.trabalhoii.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.trabalhoii.data.model.Aluno

@Dao
interface AlunoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAluno(aluno: Aluno)

    @Query("SELECT * FROM aluno")
    suspend fun getAllAlunos(): List<Aluno>

    @Query("SELECT * FROM aluno WHERE id = :id")
    suspend fun getAlunoById(id: Int): Aluno?

    @Update
    suspend fun updateAluno(aluno: Aluno)

    @Delete
    suspend fun deleteAluno(aluno: Aluno)
}