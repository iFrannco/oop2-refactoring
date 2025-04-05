package oop2.tp3.ejercicio1;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private List<Alquiler> alquileres = new ArrayList<Alquiler>();
    private String name;

    public Cliente(String nombre) {
        this.name = nombre;
    }

    public Object[] calcularDeudaYPuntosObtenidos() {
        Object[] resultado = new Object[2];
        double total = 0;
        int puntosAlquilerFrecuente = 0;
        for (Alquiler alquiler : alquileres) {
            // double monto = 0;
// determine amounts for each line
            // PLAN
            // Hacer una interfaz libro
            // crear clases concretas de libros por tipo
            // mover cada uno de los case a las clases que pertencen.

            total += alquiler.copia().libro().calcularDeuda(alquiler.diasAlquilados());

//            switch (alquiler.copia().libro().codigoPrecio()) {
//                case Libro.REGULARES:
//                    monto += 2;
//                    if (alquiler.diasAlquilados() > 2)
//                        monto += (alquiler.diasAlquilados() - 2) * 1.5;
//                    break;
//                case Libro.NUEVO_LANZAMIENTO:
//                    monto += alquiler.diasAlquilados() * 3;
//                    break;
//                case Libro.INFANTILES:
//                    monto += 1.5;
//                    if (alquiler.diasAlquilados() > 3)
//                        monto += (alquiler.diasAlquilados() - 3) * 1.5;
//                    break;
//            }
            // total += monto;
            // sumo puntos por alquiler
            puntosAlquilerFrecuente++;
            // bonus por dos días de alquiler de un nuevo lanzamiento
            puntosAlquilerFrecuente += alquiler.copia().libro().aplicarBonus(alquiler.diasAlquilados());
//            if ((alquiler.copia().libro().codigoPrecio() == Libro.NUEVO_LANZAMIENTO)
//                    && alquiler.diasAlquilados() > 1) {
//                puntosAlquilerFrecuente++;
//            }
        }
        resultado[0] = total;
        resultado[1] = puntosAlquilerFrecuente;
        return resultado;
    }

    public void alquilar(Alquiler rental) {
        alquileres.add(rental);
    }
}