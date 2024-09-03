fun main() {
    val numeros = Array(4) { 0 }  

    for (i in numeros.indices) {
        while (true) {
            println("Ingresa un número entero (${i + 1}/4):")
            try {
                numeros[i] = readLine()?.toInt() ?: throw NumberFormatException("Invalido")
                break 
            } catch (e: NumberFormatException) {
                println("Invalido, ingrese un número entero.")
            }
        }
    }

    println("Números ingresados:")
    for (numero in numeros) {
        print("$numero ")
    }

    val max = numeros.maxOrNull()
    println("\nEl número mayor es: $maximo")
}
