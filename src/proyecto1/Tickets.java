package proyecto1;


import java.util.Scanner;
import proyecto1.Fila;
import proyecto1.Nodo;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author danir
 */
public class Tickets {     
Scanner Sct = new Scanner(System.in);// 
public String generarTicket(int numeroTicket) {
    System.out.println("A= Adulto Mayor");
    System.out.println("B= Mujer Embarazada");
    System.out.println("C= Discapacitada");
    System.out.println("D= 2 o mas Asuntos");
    System.out.println("E= Plataformas");
    System.out.println("F= Hombre");
    System.out.println("G= Mujer");

    String letra = Sct.nextLine();
    String prioridad = letra.toUpperCase();

    if (prioridad.equals("A") || prioridad.equals("B") || prioridad.equals("C") || prioridad.equals("D") 
        || prioridad.equals("E") || prioridad.equals("F") || prioridad.equals("G")) {

        String ticket = prioridad + numeroTicket;
        System.out.println("Ticket generado: " + ticket);
        return ticket;

    } else {
        System.out.println("Opción incorrecta");
        return null;  // o puedes manejar el error como quieras
    }
}
}