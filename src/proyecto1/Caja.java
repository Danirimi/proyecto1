package proyecto1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Caja {
    private ArrayList<Nodo> atendidos = new ArrayList<>();
    private int tiempoTotalAtencion;
    private boolean esPlataforma;
    private boolean ocupada;
    private Map<String, Integer> tiempoPorTicket = new HashMap<>();

    public Caja(boolean esPlataforma) {
        this.esPlataforma = esPlataforma;
        this.tiempoTotalAtencion = 0;
        this.ocupada = false;
    }

    public void atender(Fila fila, Nodo cliente) {
        ocupada = true;
        int tiempoAtencion = (int)(Math.random() * 10) + 5; // Entre 5-15 minutos por cliente
        
        try {
            // Simular tiempo de atención
            System.out.println("Caja " + (esPlataforma ? "PLATAFORMA" : "NORMAL") + 
                             " atendiendo a: " + cliente.dato + 
                             " (Tiempo estimado: " + tiempoAtencion + " min)");
            Thread.sleep(tiempoAtencion * 100); // Acelerado para demostración (100ms = 1min)
            
            // Registrar atención
            atendidos.add(cliente);
            tiempoPorTicket.put(cliente.dato, tiempoAtencion);
            tiempoTotalAtencion += tiempoAtencion;
            
            System.out.println("Atención completada para: " + cliente.dato);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            ocupada = false;
        }
    }

    public void mostrarHistorial() {
        if (atendidos.isEmpty()) {
            System.out.println("Esta caja no ha atendido a nadie aún.");
            return;
        }
        
        System.out.println("Clientes atendidos en esta caja:");
        for (Nodo n : atendidos) {
            System.out.println("- Ticket: " + n.dato + 
                             ", Tiempo atención: " + tiempoPorTicket.get(n.dato) + " min" +
                             ", Prioridad: " + n.prioridad);
        }
        System.out.println("Tiempo total de atención: " + tiempoTotalAtencion + " min");
    }

    public boolean estaOcupada() {
        return ocupada;
    }

    public boolean esPlataforma() {
        return esPlataforma;
    }

    public ArrayList<Nodo> getAtendidos() {
        return atendidos;
    }

    public int getTiempoTotalAtencion() {
        return tiempoTotalAtencion;
    }
}