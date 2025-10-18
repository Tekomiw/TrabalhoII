package com.example.trabalhoii.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.example.trabalhoii.data.model.Aluno
import com.example.trabalhoii.data.model.Treino

@Dao
interface TreinoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTreino(treino: Treino)

    @Query("SELECT * FROM treino")
    suspend fun getAllTreino(): List<Treino>

    @Transaction
    @Query("SELECT * FROM treino WHERE alunoId = :alunoId")
    suspend fun getTreinoByAlunoId(alunoId: Int): List<Aluno>

    @Update
    suspend fun updateTreino(treino: Treino)

    @Delete
    suspend fun deleteTreino(treino: Treino)
}