package oop2.refactoring.ifs;

// Quick Fixes:
// "Invert if condition"
// "Remove redundant else"
public class Dni {
    private String numeroDni;

    public Dni(String dni) {
        if (dni == null) {
            throw new RuntimeException("Dni no puede ser nulo");
        }
        if (dni.isEmpty()) {
            throw new RuntimeException("Dni no puede ser vacío");
        }
        if (!tieneLargoCorrecto(dni)) {
            throw new RuntimeException("El largo del dni no puede ser menor a 3 ni mayor a 10");
        }
        if (!todosNumeros(dni)) {
            throw new RuntimeException("Debe ingresar números solamente");
        }
        this.numeroDni = dni;
    }

    private boolean tieneLargoCorrecto(String dni) {
        return false;
    }

    private boolean todosNumeros(String dni) {
        return true;
    }
}
