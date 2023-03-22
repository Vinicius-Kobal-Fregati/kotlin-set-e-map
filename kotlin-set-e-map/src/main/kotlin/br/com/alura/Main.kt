package br.com.alura

fun main() {
    val pedidos: Map<Int, Double?> = mapOf(
        Pair(1, 20.0),
        Pair(2, 34.0),
        3 to 50.0,
        4 to null,
        5 to 150.0,
        6 to 160.0
    )

    // Com os três primeiros não dá para saber se o null é por não existir ou se é o valor de fato
    val valorPedido: Double? = pedidos[4]
    val valorPedidoComGet: Double? = pedidos.get(4)
    val chaveInexistenteGet: Double? = pedidos.get(5)
    val valorPedidoComGetValue: Double? = pedidos.getValue(4)
    try {
        // Se a chave não existir, lança exceção
        val chaveInexistenteGetValue: Double? = pedidos.getValue(5)
    } catch (e: NoSuchElementException) {
        println("Chave não existente")
    }
    println(valorPedido)
    println(valorPedidoComGet)
    println(valorPedidoComGetValue)
    println(chaveInexistenteGet)

    // Caso não exista, podemos atribuir algo
    val valorChaveZero: Double? = pedidos.getOrElse(0) {
        0.0
    }
    /*
    val valorChaveZero: Double? = pedidos.getOrElse(0, {
        null
    })
     */
    println(valorChaveZero)

    // Se não existir, assume o valor padrão
    println(pedidos.getOrDefault(1, -1.0))
    println(pedidos.getOrDefault(0, -1.0))

    // Podemos ter um Collection com os pedidos ou valores
    println(pedidos.keys)
    println(pedidos.values)

    for (numeroDePedidos in pedidos.keys) {
        println("Pedido $numeroDePedidos")
    }

    // Principais formas de fazer filtro no map
    val pedidosFiltrados = pedidos.filter { (numero, valor) ->
        numero % 2 == 0
                && valor != null
                && valor > 50.0
    }

    val pedidosAcima = pedidos.filterKeys { numero ->
        numero % 2 == 0
    }

    val pedidosPares = pedidos.filterValues { valor ->
        valor != null && valor > 50.0
    }

    println(pedidosFiltrados)
    println(pedidosAcima)
    println(pedidosPares)
}