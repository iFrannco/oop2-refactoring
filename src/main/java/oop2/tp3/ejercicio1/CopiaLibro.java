package oop2.tp3.ejercicio1;

public class CopiaLibro {
    private Libro libro;

    public CopiaLibro(Libro libro) {
        this.libro = libro;
    }

    public Libro libro() {
        return libro;
    }
    public double calcularDeuda(int diasAlquilado){
        return this.libro.calcularDeuda(diasAlquilado);
    }

    public int calcularBonus(int diasAlquilado){
        return this.libro.aplicarBonus(diasAlquilado);
    }
}