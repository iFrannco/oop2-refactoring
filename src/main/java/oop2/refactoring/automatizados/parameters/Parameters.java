package oop2.refactoring.automatizados.parameters;

//1. "Introduce Parameter": 0.1F a parametro descuento.
//2. "Inline Parameter": descuento vuelve atras
//3. "Change Signature" en cobrar, agregar String numertoTarjeta. Valor por defecto?
//3.1. Agrego el parametro directamente en la deficion de cobrar() y luego me ofrece agregarlo en los callers con default value.
//4. "Introduce Parameter Object": price, quantity, y descuento en Compra

public class Parameters {
    public void cobrar(String numeroTarjeta) {
        double total = this.calculateTotal(new Parametros(100, 2, 0.1F));
        System.out.println("Total: " + total);
    }

    private double calculateTotal(Parametros parametros) {
        var total = parametros.price() * parametros.quantity();
        return total + total * parametros.descuento();
    }

    private static record Parametros(double price, int quantity, float descuento) {
    }
}

class Caller1 {
    public void caller1() {
        var p = new Parameters();
        p.cobrar("12345");
    }
}

class Caller2 {
    public void caller2() {
        var p = new Parameters();
        p.cobrar("12345");
    }
}
