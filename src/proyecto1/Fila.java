package proyecto1;

public class Fila {
    private Nodo inicio;
    private Nodo fin;

    public Fila() {
        this.inicio = null;
        this.fin = null;
    }

    public void agregar(Nodo nuevoNodo) {
        if (inicio == null) {
            inicio = nuevoNodo;
            fin = nuevoNodo;
        } else {
            // Insertar según prioridad (menor número = mayor prioridad)
            Nodo actual = inicio;
            Nodo anterior = null;
            
            while (actual != null && actual.prioridad <= nuevoNodo.prioridad) {
                anterior = actual;
                actual = actual.siguiente;
            }
            
            if (anterior == null) { // Insertar al inicio
                nuevoNodo.siguiente = inicio;
                inicio = nuevoNodo;
            } else { // Insertar en medio o al final
                anterior.siguiente = nuevoNodo;
                nuevoNodo.siguiente = actual;
                
                if (actual == null) {
                    fin = nuevoNodo;
                }
            }
        }
    }

    public Nodo obtenerSiguiente(boolean esPlataforma) {
        if (inicio == null) return null;
        
        if (esPlataforma) {
            // Buscar específicamente tickets de plataforma (E)
            Nodo actual = inicio;
            Nodo anterior = null;
            
            while (actual != null && actual.dato.charAt(0) != 'E') {
                anterior = actual;
                actual = actual.siguiente;
            }
            
            if (actual != null) {
                if (anterior == null) {
                    inicio = actual.siguiente;
                } else {
                    anterior.siguiente = actual.siguiente;
                }
                
                if (actual == fin) {
                    fin = anterior;
                }
                
                return actual;
            }
            return null;
        } else {
            // Para cajas normales, obtener el de mayor prioridad (inicio)
            Nodo siguiente = inicio;
            inicio = inicio.siguiente;
            if (inicio == null) {
                fin = null;
            }
            return siguiente;
        }
    }

    public boolean eliminarPorDato(String dato) {
        Nodo actual = inicio;
        Nodo anterior = null;
        
        while (actual != null && !actual.dato.equals(dato)) {
            anterior = actual;
            actual = actual.siguiente;
        }
        
        if (actual == null) return false;
        
        if (anterior == null) {
            inicio = actual.siguiente;
        } else {
            anterior.siguiente = actual.siguiente;
        }
        
        if (actual == fin) {
            fin = anterior;
        }
        
        return true;
    }

    public boolean editarPorDato(String original, String nuevo) {
        Nodo actual = inicio;
        
        while (actual != null && !actual.dato.equals(original)) {
            actual = actual.siguiente;
        }
        
        if (actual == null) return false;
        
        actual.dato = nuevo;
        actual.prioridad = calcularPrioridad(nuevo.charAt(0));
        return true;
    }

    public void imprimirFila() {
        Nodo actual = inicio;
        if (actual == null) {
            System.out.println("La fila está vacía.");
            return;
        }
        
        System.out.println("Fila actual:");
        while (actual != null) {
            System.out.println("- Ticket: " + actual.dato + 
                             ", Prioridad: " + actual.prioridad + 
                             ", Tolerancia: " + actual.tolerancia + " min");
            actual = actual.siguiente;
        }
    }

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
    private int calcularPrioridad(char tipo) {
    switch (tipo) {
        case 'A': return 1;  // Adulto mayor
        case 'B': return 2;  // Embarazada o con niño
        case 'C': return 3;  // Discapacidad
        case 'D': return 4;  // Varios asuntos
        case 'E': return 5;  // Plataforma
        case 'F': return 6;  // Mujer
        case 'G': return 7;  // Hombre
        default: return 8;   // Otra prioridad baja
    }
}
}