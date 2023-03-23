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

    // Se o valor do mapa for o próprio objeto que você esta percorrendo, o associateBy é mais adequado
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
    println(pedidosFreteGratis[Pedido(numero = 1, valor = 20.0)])

    /*
    // Na busca de ter o boolean se o frete é gratis ou não, tivemos essa solução.
    // Ela não funciona corretamente, pois a chave tem que ser única, então ele vai ter no máximo 2 elementos, os últimos.
    val mapa: Map<Boolean, Pedido> =
        pedidos.associateBy { pedido -> pedido.valor > 50 }
    println(mapa)
     */


    // Agrupa todos os elementos que tenham uma mesma chave,
    // sendo que os elementos serão o valor, em forma de lista
    val pedidosFreteGratisAgrupados: Map<Boolean, List<Pedido>> =
        pedidos.groupBy { pedido ->
            pedido.valor > 50
        }

    println(pedidosFreteGratisAgrupados[true])

    val nomes: List<String> = listOf(
        "Alex",
        "Fran",
        "Gui",
        "Ana",
        "Paulo",
        "Maria",
        "Mario",
        "Gisele"
    )

    val agenda: Map<Char, List<String>> = nomes.groupBy { nome ->
        nome.first() // Devolve a primeira letra da string
    }

    println(agenda)
    println(agenda['A'])

    // Temos um Objeto do tipo Grouping, nele podemos usar fold, reduce e aggregate, além de outros métodos.
    // O Grouping exige menos recurso de memória, ele é bom para quando precisamos realizar operações em cada grupo
    // separado. Muito útil quando trabalhamos com muitos dados.
    val pedidosAgrupados: Grouping<Pedido, Boolean> = pedidos.groupingBy { pedido ->
        pedido.valor > 50.0
    }
    println(pedidosAgrupados.keyOf(Pedido(1, 20.0)))
    println(pedidosAgrupados.eachCount())

    // Devolve um map tendo como valor a somatória de todos os valores daquela chave
    val somatoriaValores: Map<Boolean, Double> = pedidosAgrupados
        .fold(0.0) { acumulador: Double, pedido: Pedido ->
            acumulador + pedido.valor
        }

    println(somatoriaValores)
}

data class Pedido(val numero: Int, val valor: Double)