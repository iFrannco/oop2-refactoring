package oop2.tp3.ejercicio1;

public class LibroInfantil extends Libro{
    public LibroInfantil(String nombre, int priceCode) {
        super(nombre, priceCode);
    }

    @Override
    public double calcularDeuda(int diasAlquilado) {
        double monto = 1.5;
        if (diasAlquilado > 3)
            monto += (diasAlquilado - 3) * 1.5;
        return monto;
    }
}
