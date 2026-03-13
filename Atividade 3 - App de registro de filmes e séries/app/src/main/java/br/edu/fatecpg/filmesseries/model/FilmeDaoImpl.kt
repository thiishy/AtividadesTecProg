package br.edu.fatecpg.filmesseries.model

class FilmeDaoImpl : FilmeDao {
    companion object {
        private val filmes = mutableListOf<Filme>()
    }

    override fun adicionarFilme(filme: Filme) {
        Companion.filmes.add(filme)
    }

    override fun listarFilmes(): List<Filme> {
        return Companion.filmes
    }
}