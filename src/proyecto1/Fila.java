package proyecto1;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author danir
 */
import java.util.ArrayList;
public class Fila {
    public Nodo inicio = null; // esta variable representa el inicio de la fila
    private Nodo fin = null;// esta variable representa el final de la fila
    private ArrayList<Nodo> fuera = new ArrayList<>();// lista donde se guardan los nodos impacientes que se salieron de la fila
    
    //metodo Constructor

    public Fila(Nodo inicio) {
    this.inicio = inicio;
    this.fin = inicio; // si solo hay un nodo
    this.fuera = new ArrayList<>();
    }

  //Get-Set

    public Nodo getInicio() {
        return inicio;
    }

    public void setInicio(Nodo inicio) {
        this.inicio = inicio;
    }

    public Nodo getFin() {
        return fin;
    }

    public void setFin(Nodo fin) {
        this.fin = fin;
    }

    public ArrayList<Nodo> getFuera() {
        return fuera;
    }

    public void setFuera(ArrayList<Nodo> fuera) {
        this.fuera = fuera;
    }
    
    
    
    //Metodo Agregar
    public void agregar(Nodo nuevo){// metodo para agregar nodos a le fila
            
            
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
     public void salidaCansancio(int minutos) {//metodo para simular cuando se cansa una persona de esperar
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
     public void imprimirFila() {//imprime la fila
    Nodo actual = inicio;
    System.out.println("Estado actual de la fila:");
    while (actual != null) {
        System.out.println("- Ticket: " + actual.dato + ", Prioridad: " + actual.prioridad + ", Tolerancia: " + actual.tolerancia);
        actual = actual.siguiente;
    }
}
     
     public boolean eliminarPorDato(String dato) {
   
    if (inicio == null) {
        return false;
    }

    // Revisar si el nodo que queremos eliminar es el primero
    if (inicio.dato.equals(dato)) {
        inicio = inicio.siguiente;
        if (inicio == null) {
            fin = null;
        }
        return true;
    }

    // Recorrer la fila para encontrar el nodo a eliminar
    Nodo actual = inicio;

    while (actual.siguiente != null) {
        // Si el siguiente nodo tiene el dato buscado
        if (actual.siguiente.dato.equals(dato)) {
            // Eliminar el nodo saltándolo
            actual.siguiente = actual.siguiente.siguiente;

            // Si se eliminó el último nodo, actualizar 'fin'
            if (actual.siguiente == null) {
                fin = actual;
            }
            return true;
        }
        // Moverse al siguiente nodo
        actual = actual.siguiente;
    }

    // Si no se encontró el dato en la fila
    return false;
}
     public boolean editarPorDato(String datoOriginal, String nuevoDato) {
    Nodo actual = inicio;

    while (actual != null) {
        if (actual.dato.equals(datoOriginal)) {
            actual.dato = nuevoDato;

            // Recalcular prioridad y tolerancia si cambió el dato
            actual.prioridad = actual.Cprioridad(nuevoDato.charAt(0));
            actual.tolerancia = (int)(Math.random() * 146 + 5);

            return true;
        }
        actual = actual.siguiente;
    }

    return false;
}
     
     
     
     }
   
