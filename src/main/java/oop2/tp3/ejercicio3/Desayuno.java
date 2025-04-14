package oop2.tp3.ejercicio3;

public class Desayuno extends Gasto {
    public static final int LIMITE = 1000;
    private int monto;

    public Desayuno(int monto) {
        this.monto = monto;
    }

    @Override
    public String obtenerNombre() {
        return "Desayuno";
    }

    public int obtenerMontoComida() {
        return this.monto;
    }

    @Override
    public boolean comidaSuperaLimite() {
        return this.monto > LIMITE;
    }

    @Override
    public int obtenerMonto() {
        return this.monto;
    }
}
