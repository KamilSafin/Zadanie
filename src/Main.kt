
fun main(args: Array<String>) {
    val dimensions = loadData(Data.file)
    val result = dimensions.sumBy { dimension ->
        calculateArea(dimension) + calculateExtraArea(dimension)
    }
    println("result: $result")
}

fun loadData(source: String): List<Dimension> {
    val rows = source.split("\n")
    val values = rows.filter { it.isNotEmpty() }.map { it.split("x") }
    return values.map { value ->
        Dimension(value[0].toInt(), value[1].toInt(), value[2].toInt())
    }
}

fun calculateExtraArea(dimension: Dimension): Int {
    val min = listOf(dimension.a, dimension.b, dimension.c).sorted()
    return min[0] * min[1]
}

fun calculateArea(dimension: Dimension): Int {
    val firstSquare = dimension.a * dimension.b
    val secondSquare = dimension.b * dimension.c
    val thirdSquare = dimension.a * dimension.c

    return 2 * firstSquare + 2 * secondSquare + 2 * thirdSquare
}