package oop2.tp3.ejercicio3;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReporteTest {

    @Test
    public void testDesayuno() {
        // Set up
        var g1 = new Desayuno(1000);
        var g2 = new Desayuno(2000);

        var reporte = new ReporteDeGastos(List.of(g1, g2));

        // Execute
        String reporteImpreso = reporte.imprimir(LocalDate.of(2014, 1, 1));
        String resultadoEsperado = "Expenses " +
                LocalDate.of(2014, 1, 1).toString() + "\n" +
                "Desayuno\t1000\t \n" +
                "Desayuno\t2000\tX\n" +
                "Gastos de comida: 3000\n" +
                "Total de gastos: 3000\n";

        // Test
        assertEquals(resultadoEsperado, reporteImpreso);

    }

    @Test
    public void testCena() {
        // Set up
        var g1 = new Cena(1000);
        var g2 = new Cena(6000);

        var reporte = new ReporteDeGastos(List.of(g1, g2));

        // Execute
        String reporteImpreso = reporte.imprimir(LocalDate.of(2013, 1, 1));
        String resultadoEsperado = "Expenses " +
                LocalDate.of(2013, 1, 1).toString() + "\n" +
                "Cena\t1000\t \n" +
                "Cena\t6000\tX\n" +
                "Gastos de comida: 7000\n" +
                "Total de gastos: 7000\n";

        // Test
        assertEquals(resultadoEsperado, reporteImpreso);

    }

    @Test
    public void testAlquierAuto() {
        // Set up
        var g1 = new AlquierAuto(1000);

        var reporte = new ReporteDeGastos(List.of(g1));

        // Execute
        String reporteImpreso = reporte.imprimir(LocalDate.of(2012, 1, 1));
        String resultadoEsperado = "Expenses " +
                LocalDate.of(2012, 1, 1).toString() + "\n" +
                "Alquier Auto\t1000\t \n" +
                "Gastos de comida: 0\n" +
                "Total de gastos: 1000\n";

        // Test
        assertEquals(resultadoEsperado, reporteImpreso);

    }

}
