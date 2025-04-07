package oop2.tp3.ejercicio3;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReporteTest {

    @Test
    public void testReporte(){
        // Set up
        var g1 = new Gasto();
        g1.tipoGasto = TipoDeGasto.DESAYUNO;
        g1.monto =1000;
        var reporte = new ReporteDeGastos(List.of(g1));

        // Execute
        String reporteImpreso = reporte.imprimir();
        String resultadoEsperado = "Expenses 2025-04-06\n" +
                "Desayuno\t1000\t \n" +
                "Gastos de comida: 1000\n" +
                "Total de gastos: 1000\n";

        // Test
        assertEquals(resultadoEsperado, reporteImpreso);

    }
}
