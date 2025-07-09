
package proyecto1;
import java.util.Scanner;

public class Proyecto1 {

    public static void main(String[] args) {
        int CantidadTicket =0;
        while (CantidadTicket <25){  
        Scanner Sc = new Scanner(System.in);
        System.out.println("A= Adulto Mayor");
        System.out.println("B= Mujer Embarazada");
        System.out.println("C= Discapasitada");
        System.out.println("D= 2 o mas Asuntos");
        System.out.println("E= Plataformas");
        System.out.println("F= Hombre");
        System.out.println("G= Mujer");
        String Letra = Sc.nextLine();
        String Prioridad = Letra.toUpperCase();
        if (Prioridad.equals("A") || Prioridad.equals("B")| Prioridad.equals("C")| Prioridad.equals("D")| Prioridad.equals("E")| Prioridad.equals("F")| Prioridad.equals("G")) {
        String NumeroTicket = Integer.toString(CantidadTicket);
        String Ticket = NumeroTicket+Prioridad; 
        System.out.println(Ticket);
        CantidadTicket++;  
        Nodo Minutos = new Nodo (Ticket);   
        }else{
            System.out.println("Opcion Incorrecta");
        }
        }
    } 
}
