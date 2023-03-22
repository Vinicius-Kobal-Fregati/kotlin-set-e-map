package br.com.alura

fun main() {
    val banco = BancoDeNomes()
    // Quebraria o encapsulamento, alguém externo está alterando livremente o valor interno
    //BancoDeNomes.dados.add("Vinícius")
    banco.salva("Vinícius")
    println(banco.nomes)
    println(BancoDeNomes().nomes)
}

class BancoDeNomes {
    val nomes: Collection<String> get() = dados

    fun salva(nome: String) {
        dados.add(nome)
    }

    // Modo de manter o atributo estático no Kotlin
    companion object {
        private val dados = mutableListOf<String>()
    }
}

fun testaColecao() {
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

    val nomesMutableCollection: MutableCollection<String> = nomes.toMutableList()
    nomesMutableCollection.add("Paulo")
    nomesMutableCollection.remove("Alex")
    println(nomesMutableCollection)
}