package br.edu.fatecpg.filmesseries.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.edu.fatecpg.filmesseries.R
import br.edu.fatecpg.filmesseries.model.Filme

class FilmeAdapter(private val filmes: List<Filme>) :
    RecyclerView.Adapter<FilmeAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewTitulo: TextView = itemView.findViewById(R.id.txv_filme)
        val textViewGenero: TextView = itemView.findViewById(R.id.txv_genero)
        val textViewNota: TextView = itemView.findViewById(R.id.txv_nota)
        val switchAssistido: Switch = itemView.findViewById(R.id.swt_assistido)
        val editTextNota: EditText = itemView.findViewById(R.id.edt_nota)
        val buttonSalvar: Button = itemView.findViewById(R.id.btn_salvar_nota)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_filme, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return filmes.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val filme = filmes[position]
        val context = holder.itemView.context

        holder.switchAssistido.setOnCheckedChangeListener(null)

        holder.textViewTitulo.text =
            context.getString(R.string.titulo_com_valor, filme.titulo)
        holder.textViewGenero.text =
            context.getString(R.string.genero_com_valor, filme.genero)

        holder.textViewNota.text = if (filme.nota != null) {
            context.getString(R.string.nota_com_valor, filme.nota.toString())
        } else {
            context.getString(R.string.sem_nota)
        }

        holder.switchAssistido.isChecked = filme.assistido
        holder.editTextNota.visibility = if (filme.assistido) View.VISIBLE else View.GONE
        holder.buttonSalvar.visibility = if (filme.assistido) View.VISIBLE else View.GONE

        holder.switchAssistido.setOnCheckedChangeListener { _, isChecked ->
            filme.assistido = isChecked

            val visibility = if (isChecked) View.VISIBLE else View.GONE
            holder.editTextNota.visibility = visibility
            holder.buttonSalvar.visibility = visibility
        }

        holder.buttonSalvar.setOnClickListener {
            val notaTexto = holder.editTextNota.text.toString()
            val notaConvertida = notaTexto.toDoubleOrNull()

            if (notaConvertida != null && notaConvertida in 0.0..10.0) {
                filme.nota = notaConvertida

                holder.textViewNota.text =
                    context.getString(R.string.nota_com_valor, filme.nota.toString())
                holder.editTextNota.text.clear()
            } else {
                holder.editTextNota.error = "A nota deve estar entre 0 e 10."
            }
        }
    }

}