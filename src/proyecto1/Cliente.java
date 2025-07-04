//Libreria
package proyecto1;
//Variables
public class Cliente {
private int Opcion ;
public int Numero;
private String Letra;
//Constructor    
    public Cliente(int Opcion,int Numero,String Letra) {
        this.Opcion = Opcion;
        this.Numero = Numero;
        this.Letra = Letra;
    }
    
//Get-Set Opcion
    public int getOpcion() {
        return Opcion;
    }

    public void setOpcion(int Opcion) {
        this.Opcion = Opcion;
    }
    
//Get-Set Numero

    public int getNumero() {
        return Numero;
    }

    public void setNumero(int Numero) {
        this.Numero = Numero;
    }
  
    
//Get-Set Letra

    public String getLetra() {
        return Letra;
    }

    public void setLetra(String Letra) {
        this.Letra = Letra;
    }
    
    
//Metodo Tickete-Prioridad
   public void Prioridad(){
       
       switch (Opcion){
        case 1:{
        Letra="A";
        String Ticket1 = Integer.toString(Numero);
        String Ticket2 = Ticket1+Letra;
        System.out.println("Su numero de Tikete es ="+Ticket2);
        break;
    } 
        case 2:{
        Letra="B";
        String Ticket1 = Integer.toString(Numero);
         String Ticket2 = Ticket1+Letra;
        System.out.println("Su numero de Tikete es ="+Ticket2);
        break;
    } 
           case 3:{
        Letra="C";
        String Ticket1 = Integer.toString(Numero);
         String Ticket2 = Ticket1+Letra;
        System.out.println("Su numero de Tikete es ="+Ticket2);
        break;        
    } 
              case 4:{
        Letra="D";
        String Ticket1 = Integer.toString(Numero);
         String Ticket2 = Ticket1+Letra;
        System.out.println("Su numero de Tikete es ="+Ticket2);
        break;
    } 
            case 5:{
        Letra="E";
        String Ticket1 = Integer.toString(Numero);
         String Ticket2 = Ticket1+Letra;
        System.out.println("Su numero de Tikete es ="+Ticket2);
        break;
    }
        case 6:{
        Letra="F";
        String Ticket1 = Integer.toString(Numero);
         String Ticket2 = Ticket1+Letra;
        System.out.println("Su numero de Tikete es ="+Ticket2);
        break;
    }     
        case 7:{
        Letra="G";
        String Ticket1 = Integer.toString(Numero);
         String Ticket2 = Ticket1+Letra;
        System.out.println("Su numero de Tikete es ="+Ticket2);
        break;
        } 
    }
}
    
    
   }


         
 




