package oop2.tp3.ejercicio5;

public class Comedia extends Actuacion {
    protected Comedia(String nombreEvento, int numberoEspectadores) {
        super(nombreEvento, numberoEspectadores);
    }

    @Override
    public float calcularMonto() {
        float monto = 30000;
        if (this.numberoEspectadores() > 20) {
            monto += 10000 + 500 * (this.numberoEspectadores() - 20);
        }
        monto += 300 * this.numberoEspectadores();
        return monto;
    }

    @Override
    public double calcularCreditosAdicionales() {
        return Math.floor(numberoEspectadores() / 5);
    }
}
