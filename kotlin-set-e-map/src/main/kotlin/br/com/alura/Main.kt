package br.com.alura

fun main() {
    val pedidos: List<Pedido> = listOf(
        Pedido(1, 20.0),
        Pedido(2, 60.0),
        Pedido(3, 30.0),
        Pedido(4, 70.0)
    )
    println(pedidos)
    // Forma de transformar um Iterable em um map
    val pedidosMapeados: Map<Int, Pedido> = pedidos.associate { pedido: Pedido ->
        //Pair(pedido.numero, pedido)
        pedido.numero to pedido
    }

    // Se o valor do mapa for o próprio objeto que você está percorrendo, o associateBy é mais adequado
    val pedidosMapeadosBy = pedidos.associateBy { pedido ->
        // Passamos a associação do map, a chave
        pedido.numero
    }

    println(pedidos)
    println(pedidosMapeados[1])

    // Associa nosso iterable ao map, sendo o elemento a chave e o que passarmos o valor.
    val pedidosFreteGratis: Map<Pedido, Boolean> = pedidos.associateWith { pedido ->
        // Aqui passamos o valor que queremos, a chave será o elemento percorrido
        pedido.valor > 50
    }
    println(pedidosFreteGratis)
    println(pedidosFreteGratis[Pedido(1, 20.0)])
}

data class Pedido(val numero: Int, val valor: Double)