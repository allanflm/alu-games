package br.com.alura.alugames.modelo

interface Recomandavel {
    val media: Double

    fun recomendar(nota: Int)
}