package proyecto1;

import java.util.ArrayList;

public class Caja {
    private ArrayList<Nodo> atendidos = new ArrayList<>();
    private int tiempo; // tiempo total de atención, puedes usarlo si quieres simular duración

    // Constructor
    public Caja() {
        this.atendidos = new ArrayList<>();
        this.tiempo = 0;
    }

    // Método para atender cierta cantidad de nodos
    public void atender(Fila fila, int cantidadAtender) {
        for (int i = 0; i < cantidadAtender; i++) {
            Nodo nodoAtendido = fila.getInicio();

            if (nodoAtendido == null) {
                System.out.println("La fila está vacía, no hay más por atender.");
                break;
            }

            // Agregar a la lista de atendidos
            atendidos.add(nodoAtendido);
            System.out.println("Atendiendo a: " + nodoAtendido.dato);

            // Eliminar de la fila
            fila.setInicio(nodoAtendido.siguiente);

            // Si ya no hay más, actualizar el fin
            if (fila.getInicio() == null) {
                fila.setFin(null);
            }

            // Simular tiempo de atención por persona (opcional)
            tiempo += 3; // por ejemplo, 3 minutos por persona
        }
    }

    public void imprimirAtendidos() {
        System.out.println("Clientes atendidos:");
        for (Nodo n : atendidos) {
            System.out.println("- Ticket: " + n.dato + ", Prioridad: " + n.prioridad + ", Tolerancia: " + n.tolerancia);
        }
    }

    public ArrayList<Nodo> getAtendidos() {
        return atendidos;
    }

    public int getTiempo() {
        return tiempo;
    }
}