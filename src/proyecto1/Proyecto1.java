package proyecto1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Proyecto1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean ejecutando = true;
        Tickets generadorTickets = new Tickets();
        Fila filaBanco = new Fila();
        int contador = 0;
        
        // Crear 5 cajas normales y 1 de plataforma
        Caja[] cajas = new Caja[6];
        for (int i = 0; i < 5; i++) {
            cajas[i] = new Caja(false); // Cajas normales
        }
        cajas[5] = new Caja(true); // Caja de plataforma

        System.out.println("BIENVENIDO AL BANCO DEL PROYECTO 1 DE PROGRAMACION CON EL PROFESOR ANDRES DE LA CARRERA DE ITI DE LA UTN CEDE SAN CARLOS Y QUE ESTAMOS EN EL AULA 323");
        
        while (ejecutando) {
            contador++;
            System.out.println("\n--- MENU PRINCIPAL ---");
            System.out.println("1. Generar nuevo ticket");
            System.out.println("2. Eliminar ticket de la fila");
            System.out.println("3. Modificar ticket");
            System.out.println("4. Mostrar fila actual");
            System.out.println("5. Atender clientes en cajas");
            System.out.println("6. Mostrar historial de atencion");
            System.out.println("7. Salir del sistema");
            System.out.println("8. Mostrar reportes del sistema");
            System.out.print("Seleccione una opcion: ");
            
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer
            
            switch (opcion) {
                case 1 -> {
                    if(contador>25){
                        System.out.println("la fila ya esta llena");
                    }else{
                        String nuevoTicket = generadorTickets.generarTicket();
                    if (nuevoTicket != null) {
                        Nodo nuevoCliente = new Nodo(nuevoTicket);
                        filaBanco.agregar(nuevoCliente);
                        System.out.println("Cliente agregado a la fila.");
                    }
                    }
                    
                }
                    
                case 2 -> {
                    System.out.println("Tickets en fila:");
                    filaBanco.imprimirFila();
                    System.out.print("Ingrese el ticket a eliminar: ");
                    String ticketEliminar = scanner.nextLine();
                    if (filaBanco.eliminarPorDato(ticketEliminar)) {
                        System.out.println("Ticket eliminado correctamente.");
                    } else {
                        System.out.println("No se encontró el ticket en la fila.");
                    }
                }
                    
                case 3 -> {
                    System.out.println("Tickets en fila:");
                    filaBanco.imprimirFila();
                    System.out.print("Ingrese el ticket a modificar: ");
                    String ticketOriginal = scanner.nextLine();
                    System.out.print("Ingrese el nuevo valor del ticket: ");
                    String ticketNuevo = scanner.nextLine();
                    if (filaBanco.editarPorDato(ticketOriginal, ticketNuevo)) {
                        System.out.println("Ticket modificado correctamente.");
                    } else {
                        System.out.println("No se encontró el ticket en la fila.");
                    }
                }
                    
                case 4 -> filaBanco.imprimirFila();
                    
case 5 -> {
    filaBanco.SimularTiempo();  // Simula avance de tiempo y elimina impacientes
    System.out.println("Atendiendo clientes...");
    for (int i = 0; i < cajas.length; i++) {
        if (!cajas[i].estaOcupada()) {
            Nodo siguiente = filaBanco.obtenerSiguiente(cajas[i].esPlataforma());
            if (siguiente != null) {
                cajas[i].atender(filaBanco, siguiente);  // Atención sin hilo
            }
        }
    }
}
                    
                case 6 -> {
                    System.out.println("\nHISTORIAL DE ATENCIÓN");
                    for (int i = 0; i < cajas.length; i++) {
                        System.out.println("\nCaja " + (i + 1) + (cajas[i].esPlataforma() ? " (PLATAFORMA)" : " (NORMAL)"));
                        cajas[i].mostrarHistorial();
                    }
                }
                    
                case 7 -> {
                    ejecutando = false;
                    System.out.println("Saliendo del sistema...");
                }
                case 8 -> {
    System.out.println("\n--- REPORTE DEL SISTEMA ---");

    int totalClientes = generadorTickets.getContador();
    int totalAtendidos = 0;
    int totalSinAtender = filaBanco.contarElementos(); // los que se fueron o no fueron llamados

    Map<Character, Integer> categoriasTotales = new HashMap<>();

    for (int i = 0; i < cajas.length; i++) {
        totalAtendidos += cajas[i].getCantidadAtendidos();

        // Acumular por categoría
        Map<Character, Integer> categoriasCaja = cajas[i].getCategoriasAtendidas();
        for (Map.Entry<Character, Integer> entry : categoriasCaja.entrySet()) {
            char letra = entry.getKey();
            int cantidad = entry.getValue();
            categoriasTotales.put(letra, categoriasTotales.getOrDefault(letra, 0) + cantidad);
        }
    }

    System.out.println("1. Total de clientes que entraron al banco: " + totalClientes);
    System.out.println("2. Total de clientes atendidos: " + totalAtendidos);
    System.out.println("3. Total de clientes que no fueron atendidos: " + totalSinAtender);

    System.out.println("\n4. Clientes atendidos por cada caja:");
    for (int i = 0; i < cajas.length; i++) {
        System.out.println("- Caja " + (i + 1) + (cajas[i].esPlataforma() ? " (PLATAFORMA)" : "")
            + ": " + cajas[i].getCantidadAtendidos() + " clientes");
    }

    System.out.println("\n5. Promedio de espera por cada caja:");
    for (int i = 0; i < cajas.length; i++) {
        System.out.printf("- Caja %d%s: %.2f min\n",
            (i + 1),
            cajas[i].esPlataforma() ? " (PLATAFORMA)" : "",
            cajas[i].getPromedioEspera());
    }

    System.out.println("\n6. Total de clientes atendidos por categoría:");
    for (Map.Entry<Character, Integer> entry : categoriasTotales.entrySet()) {
        System.out.println("- " + entry.getKey() + ": " + entry.getValue() + " clientes");
    }
}  
                default -> System.out.println("Opción no válida. Intente nuevamente.");
                
            }
        }
        
        scanner.close();
    }
    
    
}