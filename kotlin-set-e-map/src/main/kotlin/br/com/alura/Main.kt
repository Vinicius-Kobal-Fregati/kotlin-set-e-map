package br.com.alura

fun main() {
    val assistiramCursoAndroid: List<String> = listOf("Alex", "Fran", "Gui", "Maria")
    val assistiramCursoKotlin: List<String> = listOf("Alex", "Paulo", "Maria")
    val assistiramAmbos:MutableList<String> = mutableListOf<String>()
    val assistiramAmbos2: List<String> = assistiramCursoAndroid + assistiramCursoKotlin
    assistiramAmbos.addAll(assistiramCursoAndroid)
    assistiramAmbos.addAll(assistiramCursoKotlin)
    // Distinct não mostra os valores repetidos
    println(assistiramAmbos.distinct())
}