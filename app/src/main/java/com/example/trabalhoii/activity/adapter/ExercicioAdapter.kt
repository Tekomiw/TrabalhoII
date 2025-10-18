package com.example.trabalhoii.activity.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageButton
import android.widget.TextView
import com.example.trabalhoii.data.model.Exercicio
import com.example.trabalhoii.data.model.Treino

class ExercicioAdapter (
    context: Context,
    private var exercicios: MutableList<Exercicio>,
    private var treinos: List<Treino>,
    private var onEdit: (Exercicio) -> Unit,
    private var onDelete: (Exercicio) -> Unit
) : ArrayAdapter<Exercicio>(context, 0, exercicios){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val exercicio = exercicios[position]
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.item_exercicio, parent, false)

        val textViewNome = view.findViewById<TextView>(R.id.textViewNomeExercicio)
        val buttonEditar = view.findViewById<ImageButton>(R.id.buttonEditarExercicio)
        val buttonDeletar = view.findViewById<ImageButton>(R.id.buttonDeletarExercicio)

        val treino = treinos.firstOrNull {it.id == exercicio.treinoId}

        textViewNome.text = if(treino != null) {
            "${exercicio.nome} - ${treino.nome}"
        } else{
            exercicio.nome
        }

        buttonEditar.setOnClickListener {
            onEdit(exercicio)
        }

        buttonDeletar.setOnClickListener {
            onDelete(exercicio)
        }

        return view
    }

    fun atualizarExercicio(novosExercicios: List<Exercicio>, novosTreinos: List<Treino>){
        exercicios.clear()
        exercicios.addAll(novosExercicios)
        treinos = novosTreinos
        notifyDataSetChanged()
    }
}