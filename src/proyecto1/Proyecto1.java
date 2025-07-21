package proyecto1;

import java.util.Scanner;

public class Proyecto1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean ejecutando = true;
        Tickets generadorTickets = new Tickets();
        Fila filaBanco = new Fila();
        
        // Crear 5 cajas normales y 1 de plataforma
        Caja[] cajas = new Caja[6];
        for (int i = 0; i < 5; i++) {
            cajas[i] = new Caja(false); // Cajas normales
        }
        cajas[5] = new Caja(true); // Caja de plataforma

        System.out.println("BIENVENIDO AL SISTEMA DE GESTIÓN DE FILAS DEL BANCO");
        
        while (ejecutando) {
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("1. Generar nuevo ticket");
            System.out.println("2. Eliminar ticket de la fila");
            System.out.println("3. Modificar ticket");
            System.out.println("4. Mostrar fila actual");
            System.out.println("5. Atender clientes en cajas");
            System.out.println("6. Mostrar historial de atención");
            System.out.println("7. Salir del sistema");
            System.out.print("Seleccione una opción: ");
            
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer
            
            switch (opcion) {
                case 1:
                    String nuevoTicket = generadorTickets.generarTicket();
                    if (nuevoTicket != null) {
                        Nodo nuevoCliente = new Nodo(nuevoTicket);
                        filaBanco.agregar(nuevoCliente);
                        System.out.println("Cliente agregado a la fila.");
                    }
                    break;
                    
                case 2:
                    System.out.println("Tickets en fila:");
                    filaBanco.imprimirFila();
                    System.out.print("Ingrese el ticket a eliminar: ");
                    String ticketEliminar = scanner.nextLine();
                    if (filaBanco.eliminarPorDato(ticketEliminar)) {
                        System.out.println("Ticket eliminado correctamente.");
                    } else {
                        System.out.println("No se encontró el ticket en la fila.");
                    }
                    break;
                    
                case 3:
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
                    break;
                    
                case 4:
                    filaBanco.imprimirFila();
                    break;
                    
                case 5:
                    System.out.println("Atendiendo clientes...");
                    for (int i = 0; i < cajas.length; i++) {
                        if (!cajas[i].estaOcupada()) {
                            Nodo siguiente = filaBanco.obtenerSiguiente(cajas[i].esPlataforma());
                            if (siguiente != null) {
                                final int cajaIndex = i;
                                new Thread(() -> {
                                    cajas[cajaIndex].atender(filaBanco, siguiente);
                                }).start();
                            }
                        }
                    }
                    break;
                    
                case 6:
                    System.out.println("\nHISTORIAL DE ATENCIÓN");
                    for (int i = 0; i < cajas.length; i++) {
                        System.out.println("\nCaja " + (i + 1) + (cajas[i].esPlataforma() ? " (PLATAFORMA)" : " (NORMAL)"));
                        cajas[i].mostrarHistorial();
                    }
                    break;
                    
                case 7:
                    ejecutando = false;
                    System.out.println("Saliendo del sistema...");
                    break;
                    
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
        
        scanner.close();
    }
}