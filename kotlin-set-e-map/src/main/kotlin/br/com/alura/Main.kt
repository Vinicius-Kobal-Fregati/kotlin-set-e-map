package br.com.alura

fun main() {
    val assistiramCursoAndroid: List<String> = listOf("Alex", "Fran", "Gui", "Maria")
    val assistiramCursoKotlin: List<String> = listOf("Alex", "Paulo", "Maria")
    val assistiramAmbos:MutableList<String> = mutableListOf<String>()
    val assistiramAmbosSoma: List<String> = assistiramCursoAndroid + assistiramCursoKotlin
    assistiramAmbos.addAll(assistiramCursoAndroid)
    assistiramAmbos.addAll(assistiramCursoKotlin)
    // Distinct não mostra os valores repetidos
    println(assistiramAmbos.distinct())

    val assistiramCursoAndroid2: MutableSet<String> = mutableSetOf("Alex", "Fran", "Gui", "Maria")
    val assistiramCursoKotlin2: MutableSet<String> = mutableSetOf("Alex", "Paulo", "Maria")
    // O próprio set não aceita elementos repetidos
    //val assistiramAmbosSet:Set<String> = assistiramCursoAndroid2 + assistiramCursoKotlin2
    //println(assistiramAmbosSet)

    val assistiramAmbosMutableSet: MutableSet<String> = mutableSetOf()
    assistiramAmbosMutableSet.addAll(assistiramCursoAndroid2)
    assistiramAmbosMutableSet.addAll(assistiramCursoKotlin2)
    assistiramAmbosMutableSet.add("Gui")
    assistiramAmbosMutableSet.add("Ana")
    println(assistiramAmbosMutableSet)
}