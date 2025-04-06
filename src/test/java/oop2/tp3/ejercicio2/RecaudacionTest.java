package oop2.tp3.ejercicio2;


import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class RecaudacionTest {

    @Test
    public void testProcesarDatosGivenCompany() throws IOException {
        var importador = new ImportadorFake();
        var recaudacion = new Recaudacion(importador);
        Map<String, String> options = new HashMap<String, String>();
        options.put("company_name", "Facebook");
        assertEquals(recaudacion.procesarDatos(options).size(), 1);
    }

    @Test
    public void testProcesarDatosGivenCity() throws IOException {
        var importador = new ImportadorFake();
        var recaudacion = new Recaudacion(importador);
        Map<String, String> options = new HashMap<String, String>();
        options.put("city", "Tempe");
        assertEquals(recaudacion.procesarDatos(options).size(), 0);
    }

    @Test
    public void testProcesarDatosGivenState() throws IOException {
        var importador = new ImportadorFake();
        var recaudacion = new Recaudacion(importador);
        Map<String, String> options = new HashMap<String, String>();
        options.put("state", "CA");
        assertEquals(recaudacion.procesarDatos(options).size(), 2);
    }

    @Test
    public void testProcesarDatosGivenRound() throws IOException {
        var importador = new ImportadorFake();
        var recaudacion = new Recaudacion(importador);
        Map<String, String> options = new HashMap<String, String>();
        options.put("round", "a");
        assertEquals(recaudacion.procesarDatos(options).size(), 0);
    }

    @Test
    public void testMultipleOptions() throws IOException {
        var importador = new ImportadorFake();
        var recaudacion = new Recaudacion(importador);
        Map<String, String> options = new HashMap<String, String>();
        options.put("round", "a");
        options.put("company_name", "Facebook");
        assertEquals(recaudacion.procesarDatos(options).size(), 0);
    }

    @Test
    public void testProcesarDatosNotExists() throws IOException {
        var importador = new ImportadorFake();
        var recaudacion = new Recaudacion(importador);
        Map<String, String> options = new HashMap<String, String>();
        options.put("company_name", "NotFacebook");
        assertEquals(recaudacion.procesarDatos(options).size(), 0);
    }

    @Test
    public void testProcesarDatosCorrectKeys() throws IOException {
        var importador = new ImportadorFake();
        var recaudacion = new Recaudacion(importador);
        Map<String, String> options = new HashMap<String, String>();
        options.put("company_name", "Facebook");
        Map<String, String> row = recaudacion.procesarDatos(options).get(0);

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
}
