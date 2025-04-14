package oop2.tp3.ejercicio2;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ImportadorCSV implements Importador {
    private String csvPath;

    public ImportadorCSV(String csvPath) {
        this.csvPath = csvPath;
    }

    @Override
    public List<String[]> importar() {

        try {
            List<String[]> csvData = new ArrayList<>();
            CSVReader reader = new CSVReader(new FileReader(this.csvPath));
            String[] row;

            while ((row = reader.readNext()) != null) {
                csvData.add(row);
            }

            reader.close();
            csvData.remove(0);
            return csvData;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
