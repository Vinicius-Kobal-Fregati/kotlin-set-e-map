package br.com.alura

fun testaMap() {
    // O to é um infix do Pair, o mais comum é o to.
    // O to tem alguns problemas de performance, para algo grande, é recomendado usar o Pair.
    val pedidos: Map<Int, Double> = mapOf(
        Pair(1, 20.0),
        Pair(2, 34.0),
        3 to 50.0
    )
    println(pedidos)
    // Pegamos os valores pela chave
    val pedido: Double? = pedidos[1]
    pedido?.let { println("Pedido $it") }

    // No for, temos o tipo como Map.Entry, ele possui a chave e valor do elemento.
    for (p: Map.Entry<Int, Double> in pedidos) {
        println(
            "Número do pedido: ${p.key}, " +
                    "valor do pedido: ${p.value}"
        )
    }

    val pedidosMutaveis: MutableMap<Int, Double> = pedidos.toMutableMap()
    // A forma mais comum de se inserir é essa primeira, o put não é tanto assim.
    pedidosMutaveis[4] = 70.0
    println(pedidosMutaveis)
    pedidosMutaveis.put(5, 80.0)
    println(pedidosMutaveis)
    // Dessa forma também podemos atualizar os valores das chaves
    pedidosMutaveis[1] = 100.0
    println(pedidosMutaveis)

    // Adiciona apenas se a chave não existir
    pedidosMutaveis.putIfAbsent(6, 120.0)
    println(pedidosMutaveis)
    // Não faz a adição pois a chave 6 já existe
    pedidosMutaveis.putIfAbsent(6, 200.0)
    println(pedidosMutaveis)

    pedidosMutaveis.remove(6)
    pedidosMutaveis.remove(3)
    // Remove apenas se a chave e o valor corresponderem ao passado
    pedidosMutaveis.remove(1, 110.0)
    println(pedidosMutaveis)
}