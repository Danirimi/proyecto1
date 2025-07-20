package proyecto1;

import java.util.Scanner;

public class Proyecto1 {

    public static void main(String[] args) {
        int a;
        boolean d;
        boolean comienzo = true;
        int CantidadTicket = 0;
        Scanner Sc = new Scanner(System.in);
        Tickets persona = new Tickets();
        Fila NFila = new Fila(null);
        Caja caja1 = new Caja(); // ← Caja agregada aquí

        System.out.println("BIENVENIDO AL BANCO: PROYECTO DE PROGRAMACION 1 CON ANDRES");

        while (comienzo) {
            d = true;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("--MENU--");
            System.out.println("1 = generar nuevo ticket y hacer fila");
            System.out.println("2 = eliminar a una persona de la fila por su ticket");
            System.out.println("3 = modificar un ticket");
            System.out.println("4 = ver la fila completa");
            System.out.println("5 = salir del banco");
            System.out.println("6 = atender clientes en caja"); // NUEVA OPCIÓN
            a = Sc.nextInt();

            switch (a) {
                case 1 -> {
                    if (CantidadTicket < 26) {
                        String agrega = persona.generarTicket(CantidadTicket);
                        if (agrega != null) {
                            Nodo nodo = new Nodo(agrega);
                            NFila.agregar(nodo);
                            CantidadTicket++;
                        } else {
                            System.out.println("Intente de nuevo.");
                        }
                    } else {
                        System.out.println("El programa no admite más de 25 datos");
                    }
                }

                case 2 -> {
                    System.out.println("¿Qué dato desea eliminar de la fila?");
                    NFila.imprimirFila();
                    Sc.nextLine();
                    while (d) {
                        System.out.println("Digite el ticket que quiere eliminar:");
                        String eliminar = Sc.nextLine();
                        System.out.println("El ticket que se quiere eliminar es: " + eliminar);
                        System.out.println("Escriba /SI/ si está correcto o /NO/ para intentar otra vez");
                        String verificar = Sc.nextLine().toUpperCase();

                        if ("SI".equals(verificar)) {
                            boolean eliminado = NFila.eliminarPorDato(eliminar);
                            if (eliminado) {
                                System.out.println("Dato eliminado exitosamente");
                            } else {
                                System.out.println("No se encontró el ticket en la fila");
                            }
                            d = false;
                        }
                    }
                }

                case 3 -> {
                    System.out.println("¿Cuál ticket desea editar?");
                    NFila.imprimirFila();
                    Sc.nextLine();
                    System.out.println("Ingrese el ticket original:");
                    String original = Sc.nextLine();
                    System.out.println("Ingrese el nuevo ticket:");
                    String nuevo = Sc.nextLine();

                    boolean editado = NFila.editarPorDato(original, nuevo);
                    if (editado) {
                        System.out.println("Ticket editado exitosamente");
                    } else {
                        System.out.println("No se encontró el ticket en la fila");
                    }
                }

                case 4 -> {
                    System.out.println("Estado actual de la fila:");
                    NFila.imprimirFila();
                }

                case 5 -> {
                    System.out.println("Gracias por usar el banco.");
                    System.exit(0);
                }

                case 6 -> {
                    System.out.println("¿Cuántas personas desea atender?");
                    int cantidad = Sc.nextInt();
                    caja1.atender(NFila, cantidad);

                    System.out.println("\n-- Clientes atendidos --");
                    caja1.imprimirAtendidos();

                    System.out.println("\nTiempo total estimado de atención: " + caja1.getTiempo() + " minutos");
                }

                default -> {
                    System.out.println("Opción no válida.");
                }
            }
        }
    }
}
