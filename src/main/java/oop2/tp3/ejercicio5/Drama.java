package oop2.tp3.ejercicio5;

public class Drama extends Actuacion {
    protected Drama(String nombreEvento, int numberoEspectadores) {
        super(nombreEvento, numberoEspectadores);
    }

    @Override
    public float calcularMonto() {
        float monto = 40000;
        if (this.numberoEspectadores() > 30) {
            monto += 1000 * (this.numberoEspectadores() - 30);
        }
        return monto;
    }

    @Override
    public double calcularCreditosAdicionales() {
        return 0;
    }
}
