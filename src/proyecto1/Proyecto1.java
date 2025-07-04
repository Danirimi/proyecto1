
package proyecto1;
import java.util.Scanner;

public class Proyecto1 {

    
    public static void main(String[] args) {
        String Letra ="Vacio";
        int NumeroTicket = 0;
        while (NumeroTicket<25){
        Scanner Sc = new Scanner (System.in);
        System.out.println("1= persona adulta");
        System.out.println("2= mujer embarazada");
        System.out.println("3= persona con alguna discapacidad");
        System.out.println("4= dos o más asuntos a tratar");
        System.out.println("5=atención de la Plataforma");
        System.out.println("6= mujer");
        System.out.println("7= hombre");
        int Opcion = Sc.nextInt();
        Cliente Prioridad = new Cliente (Opcion,NumeroTicket,Letra);
        NumeroTicket=NumeroTicket++;
        Prioridad.Prioridad();

    }    
    }
    }

