/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1;

/**
 *
 * @author danir
 */
public class Nodo {
      // clase donde se crea el nodo
    public String dato; // esta variable almacenara el dato que le pasemos
    public Nodo siguiente;// esta variable de tipo nodo apunta hacia el siguiente nodo
    public int prioridad;// esta variable contendra el tipo de prioridad del nodo
    public int tolerancia;// esta variable aalmacena el tiempo de tolerancia del nodo para ser atendido

    public Nodo(String dato) {
        this.dato = dato;
        this.siguiente = null;
        this.prioridad = Cprioridad(dato.charAt(0));
        this.tolerancia = (int)(Math.random() * 146 + 5); 
    }
    private int Cprioridad(char letra){ // metodo para calcular la prioridad de las letras
        return switch (letra) {
            case 'A' -> 1;
            case 'B' -> 2;
            case 'C' -> 3;
            case 'D' -> 4;
            case 'E' -> 5;
            default -> 6;
        };
    }
    
}
