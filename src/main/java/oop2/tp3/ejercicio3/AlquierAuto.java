package oop2.tp3.ejercicio3;

public class AlquierAuto extends Gasto {
    private int monto;

    public AlquierAuto(int monto) {
        this.monto = monto;
    }

    @Override
    public String obtenerNombre() {
        return "Alquier Auto";
    }

    @Override
    public int obtenerMonto() {
        return this.monto;
    }
}
