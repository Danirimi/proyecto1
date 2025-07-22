package proyecto1;

import java.util.Scanner;

public class Tickets {
    private Scanner scanner = new Scanner(System.in);
    private int contadorTickets = 0;

    public String generarTicket() {
        System.out.println("\nSeleccione el tipo de cliente:");
        System.out.println("A = Adulto Mayor (Prioridad Maxima)");
        System.out.println("B = Mujer Embarazada (Prioridad Alta)");
        System.out.println("C = Persona con Discapacidad (Prioridad Alta)");
        System.out.println("D = 2 o mas Asuntos (Prioridad Media)");
        System.out.println("E = Plataforma de Servicios (Prioridad Especial)");
        System.out.println("F = Hombre (Prioridad General)");
        System.out.println("G = Mujer (Prioridad General)");
        
        System.out.print("Ingrese la letra correspondiente: ");
        String input = scanner.nextLine().toUpperCase();
        
        if (input.matches("[A-G]")) {
            String ticket = input + (++contadorTickets);
            System.out.println("Ticket generado: " + ticket);
            return ticket;
        } else {
            System.out.println("Opcion incorrecta. Por favor ingrese una letra de A a G.");
            return null;
        }
    }
    public int getContador() {
    return contadorTickets;
}
}