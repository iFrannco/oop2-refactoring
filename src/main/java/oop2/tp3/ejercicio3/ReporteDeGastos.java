package oop2.tp3.ejercicio3;

import java.time.LocalDate;
import java.util.List;

enum TipoDeGasto {
    CENA, DESAYUNO, ALQUILER_AUTO
}

public class ReporteDeGastos {
    private List<Gasto> gastos;

    public ReporteDeGastos(List<Gasto> gastos) {
        this.gastos = gastos;
    }

    public String imprimir(LocalDate fechaReporte) {
        int total = 0;
        int gastosDeComida = 0;

        StringBuilder resultado = new StringBuilder();
        resultado.append("Expenses ").append(fechaReporte).append("\n");

        for (Gasto gasto : this.gastos) {
            gastosDeComida += gasto.obtenerMontoComida();
            String nombreGasto = gasto.obtenerNombre();

            String marcaExcesoComidas = gasto.comidaSuperaLimite() ? "X" : " ";

            resultado.append(nombreGasto).append("\t").append(gasto.obtenerMonto()).append("\t").append(marcaExcesoComidas).append("\n");

            total += gasto.obtenerMonto();
        }

        resultado.append("Gastos de comida: ").append(gastosDeComida).append("\n");
        resultado.append("Total de gastos: ").append(total).append("\n");

        return resultado.toString();
    }
}
