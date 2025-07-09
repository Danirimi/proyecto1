
package proyecto1;
import java.util.Scanner; 

public class Proyecto1 {
    public static void main(String[] args) {
        int a; // variable para manejar el menu principal
        int CantidadTicket =0;//variable para llevar control de cuantas personas pueden entrar
        Scanner Sc = new Scanner(System.in);// creamos nuevo scanner
        Tickets persona = new Tickets();// instancia de la clase Tickets
        Fila NFila = new Fila(null);//instancia de la clase fila
        System.out.println("BIENVENIDO AL BANCO: PROYECTO DE PROGRAMACION 1 CON ANDRES");
        while (CantidadTicket <26){  
            
            try {
                Thread.sleep(1000);  
            } catch (InterruptedException e) {// espera 1 segundo
                e.printStackTrace();
            }
            System.out.println("--MENU--");
            System.out.println("1 = generar nuevo ticket y hacer fila");
            System.out.println("2 = eliminar a una persona de la fla por su ticket");
            System.out.println("3 = modificar un ticket");
            System.out.println("4 = ver la fila completa");
            System.out.println("5 = salir del banco");
            a = Sc.nextInt();
            switch(a){
                case 1->{
                  String agrega = persona.generarTicket(CantidadTicket);
                    if (agrega != null) {
                    Nodo nodo = new Nodo(agrega);
                        NFila.agregar(nodo);
                    CantidadTicket++;
                    } else {
                    System.out.println("Intente de nuevo.");
                     }
                }
            }
        }
       
    } 
}
