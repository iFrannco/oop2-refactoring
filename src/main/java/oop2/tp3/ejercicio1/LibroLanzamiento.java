package oop2.tp3.ejercicio1;

public class LibroLanzamiento extends Libro{
    public LibroLanzamiento(String nombre, int priceCode) {
        super(nombre, priceCode);
    }

    @Override
    public double calcularDeuda(int diasAlquilado) {
        return diasAlquilado * 3;
    }

    @Override
    public int aplicarBonus(int diasAlquilado) {
        if (diasAlquilado > 1) {
            return 1;
        }
        return 0;
    }
}
