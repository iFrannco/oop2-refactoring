package oop2.tp3.ejercicio2;

import com.opencsv.CSVReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Recaudacion {

    private Importador importador;

    public Recaudacion(Importador importador) {
        this.importador = importador;
    }

    public List<Map<String, String>> procesarDatos(Map<String, String> options)
            throws IOException {
        List<String[]> csvData = this.importador.importar();

        csvData = filtrarDatos(options, "company_name", csvData, 1);
        csvData = filtrarDatos(options, "city", csvData, 4);
        csvData = filtrarDatos(options, "state", csvData, 5);
        csvData = filtrarDatos(options, "round", csvData, 9);

        return formatearDatos(csvData);
    }

    private List<Map<String, String>> formatearDatos(List<String[]> csvData) {
        List<Map<String, String>> output = new ArrayList<Map<String, String>>();
        csvData.forEach(csvDatum -> {
            Map<String, String> mapped = new HashMap<>();
            mapped.put("permalink", csvDatum[0]);
            mapped.put("company_name", csvDatum[1]);
            mapped.put("number_employees", csvDatum[2]);
            mapped.put("category", csvDatum[3]);
            mapped.put("city", csvDatum[4]);
            mapped.put("state", csvDatum[5]);
            mapped.put("funded_date", csvDatum[6]);
            mapped.put("raised_amount", csvDatum[7]);
            mapped.put("raised_currency", csvDatum[8]);
            mapped.put("round", csvDatum[9]);
            output.add(mapped);
        });
        return output;
    }

    private List<String[]> filtrarDatos(Map<String, String> options, String campo, List<String[]> csvData, int columna) {
        if (options.containsKey(campo)) {
            List<String[]> results = new ArrayList<String[]>();

            for (String[] csvDatum : csvData) {
                if (csvDatum[columna].equals(options.get(campo))) {
                    results.add(csvDatum);
                }
            }
            csvData = results;
        }
        return csvData;
    }
}
