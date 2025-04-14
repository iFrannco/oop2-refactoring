package oop2.tp3.ejercicio3;

public class Cena extends Gasto {
    public static final int LIMITE = 5000;
    private int monto;

    public Cena(int monto) {
        this.monto = monto;
    }

    @Override
    public String obtenerNombre() {
        return "Cena";
    }

    @Override
    public int obtenerMontoComida() {
        return this.monto;
    }

    @Override
    public boolean comidaSuperaLimite() {
        return monto > LIMITE;
    }

    @Override
    public int obtenerMonto() {
        return this.monto;
    }
}
