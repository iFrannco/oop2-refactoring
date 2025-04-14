package oop2.refactoring.automatizados.extractmethod;

//Tengo código duplicado? lineas 8-11 y 17-20.
//1. Uso "Extract method" y el IDE me sugiere parametrizar la diferencia.
// Si hubiera hecho a mano el movimiento podria haber metido un bug.
public class ExtractMethodPlusParameter {
    public void methodOne() {
        metodo("más lógica methodOne", "Message: ");
    }

    private static void metodo(String más_lógica_methodOne, String x) {
        System.out.println(más_lógica_methodOne);

        String[] words = {"Hello", "World", "Java"};
        for (String word : words) {
            System.out.println(x + word);
        }
    }

    public void methodTwo() {
        metodo("más lógica methodTwo", "Message:");
    }

}
