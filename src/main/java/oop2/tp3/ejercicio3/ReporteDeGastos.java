package oop2.tp3.ejercicio3;

import java.time.LocalDate;
import java.util.List;

enum TipoDeGasto {
    CENA, DESAYUNO, ALQUILER_AUTO
}

class Gasto {
    TipoDeGasto tipoGasto;
    int monto;
}

public class ReporteDeGastos {
    private List<Gasto> gastos;

    public ReporteDeGastos(List<Gasto> gastos) {
        this.gastos = gastos;
    }

    public String imprimir() {
        int total = 0;
        int gastosDeComida = 0;

        StringBuilder resultado = new StringBuilder();
        resultado.append("Expenses ").append(LocalDate.now()).append("\n");
        // System.out.println("Expenses " + LocalDate.now());

        for (Gasto gasto : this.gastos) {
            if (gasto.tipoGasto == TipoDeGasto.CENA || gasto.tipoGasto == TipoDeGasto.DESAYUNO) {
                gastosDeComida += gasto.monto;
            }

            String nombreGasto = "";
            switch (gasto.tipoGasto) {
                case CENA:
                    nombreGasto = "Cena";
                    break;
                case DESAYUNO:
                    nombreGasto = "Desayuno";
                    break;
                case ALQUILER_AUTO:
                    nombreGasto = "Alquiler de Autos";
                    break;
            }

            String marcaExcesoComidas = gasto.tipoGasto == TipoDeGasto.CENA && gasto.monto > 5000
                    || gasto.tipoGasto == TipoDeGasto.DESAYUNO && gasto.monto > 1000 ? "X" : " ";

            // System.out.println(nombreGasto + "\t" + gasto.monto + "\t" + marcaExcesoComidas);
            resultado.append(nombreGasto).append("\t").append(gasto.monto).append("\t").append(marcaExcesoComidas).append("\n");

            total += gasto.monto;
        }

        resultado.append("Gastos de comida: ").append(gastosDeComida).append("\n");
        resultado.append("Total de gastos: ").append(total).append("\n");
//        System.out.println("Gastos de comida: " + gastosDeComida);
//        System.out.println("Total de gastos: " + total);
        return resultado.toString();
    }
}
