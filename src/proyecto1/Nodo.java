package proyecto1;

import java.util.HashMap;
import java.util.Map;

public class Nodo {
    public String dato;
    public Nodo siguiente;
    public int prioridad;
    public int tolerancia;
    public int tiempoDeEspera = 0;

    public Nodo(String dato) {
        this.dato = dato;
        this.siguiente = null;
        this.prioridad = calcularPrioridad(dato.charAt(0));
        this.tolerancia = (int)(Math.random() * 146 + 5); // entre 5 y 150 minutos
    }

    public int calcularPrioridad(char letra) {
        return switch (letra) {
            case 'A' -> 1;  // Adulto mayor - máxima prioridad
            case 'B' -> 2;  // Mujer embarazada - alta prioridad
            case 'C' -> 3;  // Discapacitado - alta prioridad
            case 'D' -> 4;  // Múltiples asuntos - media prioridad
            case 'E' -> 5;  // Plataforma - prioridad especial
            case 'F', 'G' -> 6; // General - baja prioridad
            default -> 6;
        };
    }
    public int getTiempoDeEspera() {
    return tiempoDeEspera;
}

public void setTiempoDeEspera(int minutos) {
    this.tiempoDeEspera = minutos;
}

public String getDato() {
    return dato;
}

}