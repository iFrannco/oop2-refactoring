package oop2.tp3.ejercicio2;


import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class RecaudacionTest {

    @Test
    public void testProcesarDatosGivenCompany() throws IOException {
        var importador = new ImportadorFake();
        var recaudacion = new Recaudacion(importador);
        List<Map<String, String>> resultado = recaudacion.aplicarFiltro("company_name", "Facebook")
                .procesarDatos();
        assertEquals(resultado.size(), 1);
    }

    @Test
    public void testProcesarDatosGivenCity() throws IOException {
        var importador = new ImportadorFake();
        var recaudacion = new Recaudacion(importador);
        List<Map<String, String>> resultado = recaudacion.aplicarFiltro("city", "Tempe")
                .procesarDatos();
        assertEquals(resultado.size(), 0);
    }

    @Test
    public void testProcesarDatosGivenState() throws IOException {
        var importador = new ImportadorFake();
        var recaudacion = new Recaudacion(importador);
        List<Map<String, String>> resultado = recaudacion.aplicarFiltro("state", "CA")
                .procesarDatos();
        assertEquals(resultado.size(), 2);
    }

    @Test
    public void testProcesarDatosGivenRound() throws IOException {
        var importador = new ImportadorFake();
        var recaudacion = new Recaudacion(importador);
        List<Map<String, String>> resultado = recaudacion.aplicarFiltro("round", "a")
                .procesarDatos();
        assertEquals(resultado.size(), 0);
    }

    @Test
    public void testMultipleOptions() throws IOException {
        var importador = new ImportadorFake();
        var recaudacion = new Recaudacion(importador);
        List<Map<String, String>> resultado = recaudacion.aplicarFiltro("round", "a")
                .aplicarFiltro("company_name", "Facebook")
                .procesarDatos();
        assertEquals(resultado.size(), 1);
    }

    @Test
    public void testProcesarDatosNotExists() throws IOException {
        var importador = new ImportadorFake();
        var recaudacion = new Recaudacion(importador);
        List<Map<String, String>> resultado = recaudacion.aplicarFiltro("company_name", "NotFacebook")
                .procesarDatos();
        assertEquals(resultado.size(), 0);
    }

    @Test
    public void testProcesarDatosCorrectKeys() throws IOException {
        var importador = new ImportadorFake();
        var recaudacion = new Recaudacion(importador);
        List<Map<String, String>> resultado = recaudacion.aplicarFiltro("company_name", "Facebook")
                .procesarDatos();

        Map<String, String> row = resultado.get(0);


        assertEquals(row.get("permalink"), "facebook");
        assertEquals(row.get("company_name"), "Facebook");
        assertEquals(row.get("number_employees"), "450");
        assertEquals(row.get("category"), "web");
        assertEquals(row.get("city"), "Palo Alto");
        assertEquals(row.get("state"), "CA");
        assertEquals(row.get("funded_date"), "1-Sep-04");
        assertEquals(row.get("raised_amount"), "500000");
        assertEquals(row.get("round"), "angel");

    }

    @Test
    public void testCampoInexistente() throws IOException {
        var importador = new ImportadorFake();
        var recaudacion = new Recaudacion(importador);
        List<Map<String, String>> resultado = recaudacion.aplicarFiltro("noExiste", "valor")
                .procesarDatos();
        assertEquals(resultado.size(), 0);
    }
}
