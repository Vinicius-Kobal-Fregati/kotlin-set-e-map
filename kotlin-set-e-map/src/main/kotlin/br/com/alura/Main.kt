package br.com.alura

fun main() {
    val nomes: Iterable<String> = setOf(
        "Alex",
        "Fran",
        "Gui",
        "Maria",
        "Ana"
    )

    for (nome in nomes) {
        println(nome)
    }

    println(nomes)
    println("Tem o nome Vinícius? ${nomes.contains("Vinícius")}")

    val nomesCollection: Collection<String> = setOf(
        "Alex",
        "Fran",
        "Gui",
        "Maria",
        "Ana"
    )

    println("Tamanho da coleção ${nomesCollection.size}")
}