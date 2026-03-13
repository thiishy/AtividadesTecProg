package br.edu.fatecpg.filmesseries.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.edu.fatecpg.filmesseries.R
import br.edu.fatecpg.filmesseries.model.Filme
import br.edu.fatecpg.filmesseries.model.FilmeDaoImpl

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    private val filmeDao = FilmeDaoImpl()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val editTextTitulo = findViewById<EditText>(R.id.edt_titulo_filme)
        val editTextGenero = findViewById<EditText>(R.id.edt_genero_filme)
        val buttonRegistrar = findViewById<Button>(R.id.btn_registrar_filme)
        val buttonListar = findViewById<Button>(R.id.btn_listar_filmes)

        buttonRegistrar.setOnClickListener {
            val titulo = editTextTitulo.text.toString()
            val genero = editTextGenero.text.toString()

            if(titulo.isBlank()) {
                editTextTitulo.error = "O título do(a) filme/série é obrigatório."
            } else if(genero.isBlank()) {
                editTextGenero.error = "O gênero do(a) filme/série é obrigatório."
            } else {
                val filme = Filme(titulo, genero, false, null)
                filmeDao.adicionarFilme(filme)

                editTextTitulo.text.clear()
                editTextGenero.text.clear()

                Toast.makeText(this, "Filme/série registrada com sucesso!", Toast.LENGTH_SHORT).show()
            }
        }

        buttonListar.setOnClickListener {
            val intent = Intent(this, ListaFilmesActivity::class.java)
            startActivity(intent)
        }
    }
}