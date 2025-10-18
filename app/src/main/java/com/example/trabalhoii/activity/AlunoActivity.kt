package com.example.trabalhoii.activity

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.room.Room
import com.example.trabalhoii.R
import com.example.trabalhoii.activity.adapter.AlunoAdapter
import com.example.trabalhoii.data.dao.AlunoDao
import com.example.trabalhoii.data.database.AppDatabase
import com.example.trabalhoii.data.model.Aluno

class AlunoActivity : AppCompatActivity() {
    private lateinit var db: AppDatabase
    private lateinit var alunoDao: AlunoDao
    private lateinit var listViewAlunos: ListView
    private lateinit var editTextNomeAluno: EditText
    private lateinit var editTextIdadeAluno: EditText
    private lateinit var buttonAdicionarAluno: Button
    private lateinit var adapter: AlunoAdapter
    private var listaAlunos: MutableList<Aluno> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aluno)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "academia-db"
        ).build()
        alunoDao = db.alunoDao()

        listViewAlunos = findViewById(R.id.listViewAlunos)
        editTextNomeAluno = findViewById(R.id.editTextAlunoNome)
        editTextIdadeAluno = findViewById(R.id.editTextAlunoIdade)
        buttonAdicionarAluno = findViewById(R.id.buttonAdicionarAluno)

        adapter = AlunoAdapter(
            this,
            listaAlunos,
            onEdit = {aluno -> mostrarDialogoEditar(aluno)},
            onDelete = {aluno -> deletarAluno(aluno)}
        )

        listViewAlunos.adapter = adapter

        carregarAlunos()

        buttonAdicionarAluno.setOnClickListener {
            val nome = editTextNomeAluno.text.toString().trim()
            val idadeTexto = editTextIdadeAluno.text.toString().toIntOrNull()
            if (nome.isNotEmpty() && idadeTexto != null){
                adicionarAluno()
            }else{
                Toast.makeText(this, "Por favor, preencha todos os campos do aluno", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun carregarAlunos(){

    }

}