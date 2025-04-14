package oop2.tp3.ejercicio2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Recaudacion {
    public static final String COMPANY_NAME = "company_name";
    public static final String CITY_NAME = "city";
    public static final String STATE_NAME = "state";
    public static final String ROUND_NAME = "round";
    public static final String PERMALINK = "permalink";
    public static final String NUMBER_EMPLOYEES = "number_employees";
    public static final String CATEGORY = "category";
    public static final String FUNDED_DATE = "funded_date";
    public static final String RAISED_AMOUNT = "raised_amount";
    public static final String RAISED_CURRENCY = "raised_currency";
    Map<String, String> filtros;
    List<String[]> csvData;
    private Map<String, Integer> camposYSuIndice = Map.of(
            PERMALINK, 0,
            COMPANY_NAME, 1,
            NUMBER_EMPLOYEES, 2,
            CATEGORY, 3,
            CITY_NAME, 4,
            STATE_NAME, 5,
            FUNDED_DATE, 6,
            RAISED_AMOUNT, 7,
            RAISED_CURRENCY, 8,
            ROUND_NAME, 9
    );

    public Recaudacion(Importador importador) {
        this.csvData = importador.importar();
        this.filtros = new HashMap<>();
    }

    public List<Map<String, String>> procesarDatos() {
        List<String[]> results = new ArrayList<String[]>();

        for (Map.Entry<String, String> filtro : this.filtros.entrySet()) {
            if (camposYSuIndice.containsKey(filtro.getKey())) {
                for (String[] csvDatum : this.csvData) {
                    if (csvDatum[camposYSuIndice.get(filtro.getKey())].equals(this.filtros.get(filtro.getKey()))) {
                        results.add(csvDatum);
                    }
                    // csvData = results;
                }
            }
        }

        return formatearDatos(results);
    }

    private List<Map<String, String>> formatearDatos(List<String[]> csvData) {
        List<Map<String, String>> output = new ArrayList<Map<String, String>>();
        csvData.forEach(csvDatum -> {
            Map<String, String> mapped = new HashMap<>();
            mapped.put(PERMALINK, csvDatum[this.camposYSuIndice.get(PERMALINK)]);
            mapped.put(COMPANY_NAME, csvDatum[this.camposYSuIndice.get(COMPANY_NAME)]);
            mapped.put(NUMBER_EMPLOYEES, csvDatum[this.camposYSuIndice.get(NUMBER_EMPLOYEES)]);
            mapped.put(CATEGORY, csvDatum[this.camposYSuIndice.get(CATEGORY)]);
            mapped.put(CITY_NAME, csvDatum[this.camposYSuIndice.get(CITY_NAME)]);
            mapped.put(STATE_NAME, csvDatum[this.camposYSuIndice.get(STATE_NAME)]);
            mapped.put(FUNDED_DATE, csvDatum[this.camposYSuIndice.get(FUNDED_DATE)]);
            mapped.put(RAISED_AMOUNT, csvDatum[this.camposYSuIndice.get(RAISED_AMOUNT)]);
            mapped.put(RAISED_CURRENCY, csvDatum[this.camposYSuIndice.get(RAISED_CURRENCY)]);
            mapped.put(ROUND_NAME, csvDatum[this.camposYSuIndice.get(ROUND_NAME)]);
            output.add(mapped);
        });
        return output;
    }

//    private List<String[]> filtrarDatos(String nombreColumna, int indiceColumna) {
//        if (this.filtros.containsKey(nombreColumna)) {
//            List<String[]> results = new ArrayList<String[]>();
//
//            for (String[] csvDatum : this.csvData) {
//                if (csvDatum[indiceColumna].equals(this.filtros.get(nombreColumna))) {
//                    results.add(csvDatum);
//                }
//            }
//            csvData = results;
//        }
//        return csvData;
//    }

    public Recaudacion aplicarFiltro(String campo, String valorCampo) {
        // Si el filtro ya existe, lanzar una excepcion?
        this.filtros.put(campo, valorCampo);
        return this;
    }
}
