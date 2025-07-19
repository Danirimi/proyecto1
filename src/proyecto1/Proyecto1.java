
package proyecto1;
import java.util.Scanner; 

public class Proyecto1 {
     
    public static void main(String[] args) {
        int a; // variable para manejar el menu principal
        boolean d;// variable que funciona en el proceso de eliminar un dato
        boolean comienzo = true;// variable que permite permanecer en el sistema
        int CantidadTicket =0;//variable para llevar control de cuantas personas pueden entrar
        Scanner Sc = new Scanner(System.in);// creamos nuevo scanner
        Tickets persona = new Tickets();// instancia de la clase Tickets
        Fila NFila = new Fila(null);//instancia de la clase fila
        
        System.out.println("BIENVENIDO AL BANCO: PROYECTO DE PROGRAMACION 1 CON ANDRES");
        while (comienzo){ 
            d = true;
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
                   if(CantidadTicket <26){
                           String agrega = persona.generarTicket(CantidadTicket);
                    if (agrega != null) {
                    Nodo nodo = new Nodo(agrega);
                        NFila.agregar(nodo);
                    CantidadTicket++;
                    } else {
                    System.out.println("Intente de nuevo.");
                     }
                   }else{
                       System.out.println("el programa no admite mas de 25 datos");
                   }
              
                }
                case 2->{
                    System.out.println("Que dato desea eliminar de la fila?");
                    NFila.imprimirFila();
                    System.out.println(" ");
                    Sc.nextLine(); 
                    while(d){
                        System.out.println("dijte el ticket que quiere eliminar");
                        System.out.println("porfavor verifique que el ticket que ingrese coincida con uno de la fila");
                        String eliminar = Sc.nextLine();
                        System.out.println("el ticket que se quiere eliminar es :"+eliminar);
                        System.out.println("escriba /SI/ si esta correcto o /NO/ si se equivoco para intentar otra vez");
                        String verificar = Sc.nextLine();
                        String verificarM = verificar.toUpperCase();
                        if ("SI".equals(verificarM)){
                            NFila.eliminarPorDato(eliminar);
                            System.out.println("dato eliminado exitosamente");
                            d = false;
                        }
                    }
                }
                case 4->{
                    System.out.println("estado actual de la fila:");
                    NFila.imprimirFila();
                    
                }
                case 3->{
                    System.out.println("opcion para editar");
                    System.out.println("¿cual ticket desea editar?");
                    NFila.imprimirFila();
                    System.out.println(" ");
                    Sc.nextLine();
                    System.out.println("ingrese el ticket original que desea modifcar segun se observan en la fila");
                    String original = Sc.nextLine();
                    System.out.println("ingrese el nuevo ticket");
                    String nuevo = Sc.nextLine();
                    
                    boolean DEditado = NFila.editarPorDato(original, nuevo);
                      if (DEditado) {
                      System.out.println("Ticket editado exitosamente");
                    } else {
                    System.out.println("No se encontró el ticket en la fila");
                    }
                      
                }
            case 5->{
                System.exit(0);
            } 
            }
        }
       
    } 
}
