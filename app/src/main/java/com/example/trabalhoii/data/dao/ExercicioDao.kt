package com.example.trabalhoii.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.example.trabalhoii.data.model.Aluno
import com.example.trabalhoii.data.model.Exercicio

@Dao
interface ExercicioDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertExercicio(exercicio: Exercicio)

    @Query("SELECT * FROM exercicio")
    suspend fun getAllExercicio(): List<Exercicio>

    @Transaction
    @Query("SELECT * FROM exercicio WHERE treinoId = :treinoId")
    suspend fun getExercicioByTreinoId(treinoId: Int): List<Exercicio>

    @Update
    suspend fun updateExercicio(exercicio: Exercicio)

    @Delete
    suspend fun deleteExercicio(exercicio: Exercicio)

}