package oop2.tp3.ejercicio1;

public class LibroRegular extends Libro{
    public static final double MONTO = 2;
    public static final double LIMITE_DIAS = 2;
    public static final double MULTIPLICADOR = 1.5;

    public LibroRegular(String nombre, int priceCode) {
        super(nombre, priceCode);
    }

    @Override
    public double calcularDeuda(int diasAlquilado) {
        double monto = MONTO;
        if (diasAlquilado > LIMITE_DIAS)
            monto += (diasAlquilado - LIMITE_DIAS) * MULTIPLICADOR;
        return monto;
    }
}
