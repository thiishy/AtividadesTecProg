package br.edu.fatecpg.filmesseries.model

interface FilmeDao {
    fun adicionarFilme(filme: Filme)
    fun listarFilmes(): List<Filme>
}