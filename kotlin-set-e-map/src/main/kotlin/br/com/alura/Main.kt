package br.com.alura

fun main() {
    // O to é um infix do Pair, o mais comum é o to.
    // O to tem alguns problemas de performance, para algo grande, é recomendado usar o Pair.
    val pedidos: Map<Int, Double> = mapOf(Pair(1, 20.0), Pair(2, 34.0), 3 to 50.0)
    println(pedidos)
    // Pegamos os valores pela chave
    val pedido: Double? = pedidos[1]
    pedido?.let { println("Pedido $it") }

    // No for, temos o tipo como Map.Entry, ele possui a chave e valor do elemento.
    for (pedido: Map.Entry<Int, Double> in pedidos) {
        println("Número do pedido: ${pedido.key}, " +
                "valor do pedido: ${pedido.value}")
    }
}