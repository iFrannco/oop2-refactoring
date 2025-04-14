package oop2.refactoring.extractmethod;

import java.time.LocalDate;
import java.time.LocalTime;

public class Viaje {
    private LocalDate fechaSalida;
    private LocalTime horaSalida;
    private double distanciaRecorrida;

    public double costoDelViaje() {
        //¿Qué significa esta condición en las reglas del negocio?
        if (esViajeNocturno()) {
            return distanciaRecorrida * 5;
        } else {
            return distanciaRecorrida * 3;
        }
    }

    private boolean esViajeNocturno() {
        return horaSalida.getHour() > 22 || horaSalida.getHour() < 06;
    }
}
