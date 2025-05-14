package oop2.tp3.ejercicio5;

public class Calculador {

    public String reporte(Factura factura) {
        float totalAmount = 0;
        float creditos = 0;
        var result = "Facturación para " + factura.nombreCliente() + System.lineSeparator();
        var actuaciones = factura.actuaciones();
        for (var actuacion : actuaciones) {
            float monto = 0;
            monto = actuacion.calcularMonto();

            creditos += actuacion.calcularCreditos();
            result += actuacion.nombreEvento() + ": " + monto + ". Asientos: " + actuacion.numberoEspectadores() + System.lineSeparator();
            totalAmount += monto;
        }
        result += "Monto ganado: " + totalAmount + System.lineSeparator();
        result += "Créditos ganados: " + creditos + System.lineSeparator();

        return result;
    }
}
