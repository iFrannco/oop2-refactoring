package oop2.tp3.ejercicio1;

public class LibroRegular extends Libro{
    public LibroRegular(String nombre, int priceCode) {
        super(nombre, priceCode);
    }

    @Override
    public double calcularDeuda(int diasAlquilado) {
        double monto = 2;
        if (diasAlquilado > 2)
            monto += (diasAlquilado - 2) * 1.5;
        return monto;
    }
}
