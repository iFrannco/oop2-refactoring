package oop2.tp3.ejercicio1;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LibreriaTest {

    @Test
    public void testAlquiler(){
        // Set up
        var libro1 = new LibroRegular("Bajo la misma estrella", Libro.REGULARES);
        var libro2 = new LibroInfantil("El principito", Libro.INFANTILES);
        var libro3 = new LibroLanzamiento("Source code", Libro.NUEVO_LANZAMIENTO);

        var copia1 = new CopiaLibro(libro1);
        var copia2 = new CopiaLibro(libro2);
        var copia3 = new CopiaLibro(libro3);

        var alquiler1 = new Alquiler(copia1, 10);
        var alquiler2 = new Alquiler(copia2, 15);
        var alquiler3 = new Alquiler(copia3, 20);

        var cliente = new Cliente("franco");

        // Execute
        cliente.alquilar(alquiler1);
        cliente.alquilar(alquiler2);
        cliente.alquilar(alquiler3);
        Object[] resultado = cliente.calcularDeudaYPuntosObtenidos();

        // Test
        assertEquals(93.5, resultado[0]);
        assertEquals(4, resultado[1]);
    }
}
