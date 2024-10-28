//Chelsea Mariana González Molina - U20240141

import java.util. 

data class pupusa (val tipo: String, val cantidad: Int)
data class orden (val cliente: String, val pupusas: List<pupusa)

fun fun main(args: Array<String>) {
    val ordenesPendientes: Queue<orden> = LinkdList();
    val ordenesDespachadas: Stack<orden> = Stack();

    while (true){
        mostrarMenu()
        when (leerOpcion()){
            1 -> registrarOrden(ordenesPendientes)
            2 -> verOrdenesPendientes(ordenesPendientes)
            3 -> despacharOrden(ordenesPendientes, ordenesDespachadas)
            4 -> verOrdenesDespachadas(ordenesDespachadas)
            5 -> {
                println("Saliendo del programa. Gracias por su compra!");
                return
            }else -> println("Valor ingresado incorrecto. Intenta de nuevo");
        }
    }
}

fun mostrarMenuo(){
    println("\nMenú Pupuseria El Comalito.")
    println("1. Registrar una nueva orden")
    println("2. Ver ordenes pendientes")
    println("3. Despachar una orden")
    println("4. Ver ordenes despachadas")
    println("5. Salir")
    println("Seleccione una opción: ");
}

fun leerOpcion(): Int?{
    return readLine()?.toIntOrNull()
}

fun registrarOrden(ordenesPendientes: Queue<orden>){
    println("Nombre del cliente: ")
    val cliente = readLine()?.takeIf {it.isNotBlank()} ?: run{
        println("No puede estar vacio, ingrese nombre del cliente")
        return
    }

    val pupusas = mutableListOf<pupusa>()
    while(true){
        print("Tipo de pupusa ('fin' para finalizar): ")
        val tipo = readLine()?.takeIf{it.isNotBlank()} ?: break 
        if (tipo.lowercase() == "fin") break

        print("Cantidad de pupusas de tipo $tipo: ")
        val cantidad = readLine()?.toIntOrNull()
        if (cantidad == null || cantidad <= 0){
            println("Ingrese un número positivo")
            continue
        }

        pupusas.add(pupusa(tipo, cantidad))
    }
    if (pupusas.isNotEmpty()){
        ordenesPendientes.add(orden(cliente, pupusas))
        println("Orden registrada exitosamente!")
    }else{
        println("No se refistro ninguna pupusa")
    }
}

fun verOrdenesPendientes(ordenesPendientes: Queue<orden>){
    if (ordenesPendientes.isNotEmpty()){
        println("No hay ordnes pendientes")
    }else{
        println("Ordenes pendientes:")
        ordenesPendientes.forEach{ orden ->
        println("Cliente: ${orden.cliente}, Pupusas: ${orden.pupusas.joinToDtring{"${it.cantidad} de ${it.tipo}" }}")
        }
    }
}

fun despacharOrden (ordenesDespachadas: Queue<orden>, ordenesDespachadas: Stack<orden>){
    if (ordenesPendientes.isEmpty()){
        println("No hay ordenes pendientes para despachar")
    }else{
        val orden = ordenesPendientes.poll()
        ordenesDespachadas.push(orden)
        println("Orden de ${orden.cliente} despachada")
    }
}

fun verOrdenesDespachadas(ordenesDespachadas: Stack<orden>){
    if (ordenesDespachadas.isEmpty()){
        println("No hay oredenes despachadas")
    }else{
        println("Ordenes despachadas: ")
        ordenesDespachadas.forEach{orden ->
        println("Clientes: ${orden.cliente}, Pupusas: ${orden.pupusas.joinToString {"${it.cantidad} de ${it.tipo}" }}")
        }
    }
}