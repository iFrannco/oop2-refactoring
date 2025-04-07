package oop2.tp3.ejercicio1;

public class LibroLanzamiento extends Libro{
    public static final double LIMITE_DIAS = 2;
    public static final double MULTIPLICADOR = 3;
    public static final int BONUS = 1;

    public LibroLanzamiento(String nombre, int priceCode) {
        super(nombre, priceCode);
    }

    @Override
    public double calcularDeuda(int diasAlquilado) {
        return diasAlquilado * MULTIPLICADOR;
    }

    @Override
    public int aplicarBonus(int diasAlquilado) {
        if (diasAlquilado > LIMITE_DIAS) {
            return BONUS;
        }
        return 0;
    }
}
