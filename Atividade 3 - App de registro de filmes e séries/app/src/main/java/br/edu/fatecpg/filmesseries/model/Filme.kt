package br.edu.fatecpg.filmesseries.model

data class Filme(
    val titulo: String = "",
    val genero: String = "",
    var assistido: Boolean = false,
    var nota: Double? = null
) {
}