package br.edu.fatecpg.filmesseries.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.edu.fatecpg.filmesseries.R
import br.edu.fatecpg.filmesseries.adapter.FilmeAdapter
import br.edu.fatecpg.filmesseries.model.FilmeDaoImpl
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListaFilmesActivity : AppCompatActivity(R.layout.activity_lista_filmes) {
    private val filmeDao = FilmeDaoImpl()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val floatingActionButtonVoltar = findViewById<FloatingActionButton>(R.id.fab_voltar)
        val recyclerViewFilmes = findViewById<RecyclerView>(R.id.recyclerview_filmes)
        val filmes = filmeDao.listarFilmes()

        recyclerViewFilmes.layoutManager = LinearLayoutManager(this)
        recyclerViewFilmes.adapter = FilmeAdapter(filmes)

        floatingActionButtonVoltar.setOnClickListener {
            finish()
        }
    }
}