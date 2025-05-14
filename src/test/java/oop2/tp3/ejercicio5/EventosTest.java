package oop2.tp3.ejercicio5;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EventosTest {

    @Test
    public void testGeneral() {
        // set up

        var factura = new Factura("c1", List.of(new Comedia("Escuela de Rock", 158),
                new Drama("Hamlet", 103),
                new Drama("El Perfume", 8)));

        // execute
        var calculador = new Calculador();
        var resultado = calculador.reporte(factura);
        var esperado = "Facturación para c1\n" +
                "Escuela de Rock: 156400.0. Asientos: 158\n" +
                "Hamlet: 113000.0. Asientos: 103\n" +
                "El Perfume: 40000.0. Asientos: 8\n" +
                "Monto ganado: 309400.0\n" +
                "Créditos ganados: 232.0\n";

        // test
        assertEquals(esperado, resultado);
    }
}
