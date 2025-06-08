package oop2.tp3.ejercicio3;

import java.time.LocalDate;
import java.util.List;

public class EjemploDeUsoDelReporte {
    public static void main(String[] args) {
        var g1 = new Desayuno(1000);
        var reporte = new ReporteDeGastos(List.of(g1));
        String r = reporte.imprimir(LocalDate.now());
        System.out.println(r);
    }
}
