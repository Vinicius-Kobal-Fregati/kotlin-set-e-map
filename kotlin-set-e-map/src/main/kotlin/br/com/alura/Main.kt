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

    println(assistiramCursoAndroid2 + assistiramCursoKotlin2)
    // Comportamentos específicos do set
    // Union tem a característica de infix no Kotlin, podemos chamar ele sem o ponto
    println(assistiramCursoAndroid2.union(assistiramCursoKotlin2))
    println(assistiramCursoAndroid2 union(assistiramCursoKotlin2))
    // Para um argumento, não precisa dos parêntesis
    println(assistiramCursoAndroid2 union assistiramCursoKotlin2)

    // Remove os iguais que aparecem na segunda coleção
    println(assistiramCursoKotlin2 - assistiramCursoAndroid2)
    println(assistiramCursoAndroid2 subtract  assistiramCursoKotlin2)

    // Pega quem está nas duas coleções
    println(assistiramCursoAndroid2 intersect assistiramCursoKotlin2)

    val assistiramList: MutableList<String> = assistiramAmbosMutableSet.toMutableList()
    assistiramList.add("Alex")
    println(assistiramList)
    // Ao transformar para set, já excluí os itens repetidos
    println(assistiramList.toSet())
}