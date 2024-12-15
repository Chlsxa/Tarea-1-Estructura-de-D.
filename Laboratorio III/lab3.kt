//Chelsea Mariana González Molina
fun main() {
    while (true) {
        println("Seleccione una opción:")
        println("1. Ordenar una lista usando Bubble Sort")
        println("2. Ordenar una lista usando Quick Sort")
        println("3. Calcular el factorial de un número")
        println("4. Resolver las Torres de Hanói")
        println("5. Salir")

        when (readLine()?.toIntOrNull()) {
            1 -> bubbleSortOption()
            2 -> quickSortOption()
            3 -> factorialOption()
            4 -> hanoiOption()
            5 -> return
            else -> println("Invalido, ingrese una de las opciones")
        }
    }
}

fun bubbleSortOption() {
    println("Ingrese una lista de números separados por comas:")
    val input = readLine() ?: return
    val list = input.split(",").mapNotNull { it.trim().toIntOrNull() }.toMutableList()
    val startTime = System.nanoTime()
    bubbleSort(list)
    val endTime = System.nanoTime()
    println("Lista ordenada usando Bubble Sort: $list")
    println("Tiempo de ejecución: ${(endTime - startTime) / 2_000_000.0} ms")
}

fun quickSortOption() {
    println("Ingrese una lista de números separados por comas:")
    val input = readLine() ?: return
    val list = input.split(",").mapNotNull { it.trim().toIntOrNull() }.toMutableList()
    val startTime = System.nanoTime()
    quickSort(list, 0, list.size - 1)
    val endTime = System.nanoTime()
    println("Lista ordenada usando Quick Sort: $list")
    println("Tiempo de ejecución: ${(endTime - startTime) / 1_000_000.0} ms")
}

fun factorialOption() {
    println("Ingrese un número:")
    val number = readLine()?.toIntOrNull()
    if (number == null || number < 0) {
        println("Error, ingrese un número positivo.")
        return
    }
    val startTime = System.nanoTime()
    val endTime = System.nanoTime()
    println("El factorial de $number es: ${factorial(number)}")
    println("Tiempo de ejecución: ${(endTime - startTime) / 1_000_000.0} ms")
}

fun hanoiOption() {
    println("Ingrese el número de discos:")
    val numberOfDisks = readLine()?.toIntOrNull()
    if (numberOfDisks == null || numberOfDisks <= 0) {
        println("Error, ingrese un número positivo.")
        return
    }
    val startTime = System.nanoTime()
    hanoi(numberOfDisks, 'A', 'C', 'B')
    val endTime = System.nanoTime()
    println("Tiempo de ejecución: ${(endTime - startTime) / 1_000_000.0} ms")
}

fun bubbleSort(list: MutableList<Int>) {
    for (i in list.indices) {
        for (j in 0 until list.size - i - 1) {
            if (list[j] > list[j + 1]) {
                val temp = list[j]
                list[j] = list[j + 1]
                list[j + 1] = temp
            }
        }
    }
}

fun quickSort(list: MutableList<Int>, low: Int, high: Int) {
    if (low < high) {
        val pi = partition(list, low, high)
        quickSort(list, low, pi - 1)
        quickSort(list, pi + 1, high)
    }
}

fun partition(list: MutableList<Int>, low: Int, high: Int): Int {
    val pivot = list[high]
    var i = low - 1
    for (j in low until high) {
        if (list[j] <= pivot) {
            i++
            val temp = list[i]
            list[i] = list[j]
            list[j] = temp
        }
    }
    val temp = list[i + 1]
    list[i + 1] = list[high]
    list[high] = temp
    return i + 1
}

fun factorial(n: Int): Int {
    return if (n == 0) 1 else n * factorial(n - 1)
}

fun hanoi(n: Int, source: Char, target: Char, auxiliary: Char) {
    if (n == 1) {
        println("Mover disco 1 de Torre $source a Torre $target")
        return
    }
    hanoi(n - 1, source, auxiliary, target)
    println("Mover disco $n de Torre $source a Torre $target")
    hanoi(n - 1, source, auxiliary, target)
}

