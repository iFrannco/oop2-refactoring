package oop2.tp3.ejercicio2;

import com.opencsv.CSVReader;

import java.io.IOException;
import java.util.List;

public interface Importador {

    public List<String[]> importar() throws IOException;
}
