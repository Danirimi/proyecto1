/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author danir
 */
import java.util.ArrayList;
import proyecto1.Nodo;
public class Fila {
    private Nodo inicio = null; // esta variable representa el inicio de la fila
    private Nodo fin = null;// esta variable representa el final de la fila
    private ArrayList<Nodo> fuera = new ArrayList<>();// lista donde se guardan los nodos impacientes que se salieron de la fila
    
    public void agregar(String dato){
            Nodo nuevo = new Nodo(dato);
            
            if (inicio == null) {
            inicio = fin = nuevo;
        } else if (nuevo.prioridad < inicio.prioridad) {
            nuevo.siguiente = inicio;
            inicio = nuevo;
        } else {
            Nodo actual = inicio;
            while (actual.siguiente != null && actual.siguiente.prioridad <= nuevo.prioridad) {
                actual = actual.siguiente;
            }
            nuevo.siguiente = actual.siguiente;
            actual.siguiente = nuevo;

            if (nuevo.siguiente == null) {
                fin = nuevo;
            }
    }
}
     public void simularYEliminarVencidos(int minutos) {
        // Elimina los nodos cuya tolerancia fue superada
        while (inicio != null && minutos > inicio.tolerancia) {
            System.out.println("Eliminado por tolerancia: " + inicio.dato);
            fuera.add(inicio);
            inicio = inicio.siguiente;
        }
         Nodo actual = inicio;
        while (actual != null && actual.siguiente != null) {
            if (minutos > actual.siguiente.tolerancia) {
                System.out.println("Eliminado por tolerancia: " + actual.siguiente.dato);
                fuera.add(actual.siguiente);
                actual.siguiente = actual.siguiente.siguiente;
            } else {
                actual = actual.siguiente;
            }
        }

        if (inicio == null) {
            fin = null;
        }
    
}
     }
   
