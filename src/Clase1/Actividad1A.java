package Clase1;

public class Actividad1A {
    public static void main(String[] args) {
        int[] array = {1, 5, 3, 9, 2, 8, 4};
        int max = encontrarMaximo(array);
        System.out.println("El valor máximo es: " + max);
    }

    public static int encontrarMaximo(int[] array) {
        int max = array[0];  // Inicializa el maximo con el primer elemento del array
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];  // Actualiza el maximo si se encuentra un elemento mayor
            }
        }
        return max;
    }
}

//Complejidad asintonica O(n)
