package oop2.tp3.ejercicio3;

abstract class Gasto {
    public abstract String obtenerNombre();

    public int obtenerMontoComida() {
        return 0;
    }

    public boolean comidaSuperaLimite() {
        return false;
    }

    public abstract int obtenerMonto();
}
