package oop2.tp3.ejercicio5;

public abstract class Actuacion {
    private String nombreEvento;
    private int numberoEspectadores;


    protected Actuacion(String nombreEvento, int numberoEspectadores) {
        this.nombreEvento = nombreEvento;
        this.numberoEspectadores = numberoEspectadores;
    }

    public abstract float calcularMonto();

    public int numberoEspectadores() {
        return this.numberoEspectadores;
    }

    public String nombreEvento() {
        return this.nombreEvento;
    }

    public final double calcularCreditos() {
        float creditos = Math.max(numberoEspectadores() - 30, 0);
        return creditos + calcularCreditosAdicionales();
    }

    public abstract double calcularCreditosAdicionales();
}
