package oop2.tp3.ejercicio5;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        var factura = crearFactura();

        System.out.println(new Calculador().reporte(factura));
    }

    private static Factura crearFactura() {
        return new Factura("c2", List.of(new Comedia("Escuela de Rock", 158),
                new Drama("Hamlet", 103),
                new Drama("El Perfume", 8)));
    }

}
