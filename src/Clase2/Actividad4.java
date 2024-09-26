package Clase2;

public class Actividad4 {

    // Método principal que ordena el array
    public static void mergeSort(int[] array) {
        if (array.length < 2) {
            return; // Si el array tiene 0 o 1 elementos, ya está ordenado
        }
        int medio = array.length / 2;

        // Dividir el array en dos mitades
        int[] izquierda = new int[medio];
        int[] derecha = new int[array.length - medio];

        // Copiar los elementos a las mitades
        for (int i = 0; i < medio; i++) {
            izquierda[i] = array[i];
        }
        for (int i = medio; i < array.length; i++) {
            derecha[i - medio] = array[i];
        }

        // Llamadas recursivas para ordenar las mitades
        mergeSort(izquierda);
        mergeSort(derecha);

        // Mezclar las mitades ordenadas
        merge(array, izquierda, derecha);
    }

    // Método para mezclar dos mitades ordenadas
    private static void merge(int[] array, int[] izquierda, int[] derecha) {
        int i = 0, j = 0, k = 0;

        // Mezclar los elementos en orden
        while (i < izquierda.length && j < derecha.length) {
            if (izquierda[i] <= derecha[j]) {
                array[k++] = izquierda[i++];
            } else {
                array[k++] = derecha[j++];
            }
        }

        // Copiar los elementos restantes de la mitad izquierda
        while (i < izquierda.length) {
            array[k++] = izquierda[i++];
        }

        // Copiar los elementos restantes de la mitad derecha
        while (j < derecha.length) {
            array[k++] = derecha[j++];
        }
    }

    public static void main(String[] args) {
        int[] arrayDesordenado = {38, 27, 43, 3, 9, 82, 10};

        System.out.println("Array desordenado:");
        for (int numero : arrayDesordenado) {
            System.out.print(numero + " ");
        }
        System.out.println();

        mergeSort(arrayDesordenado);

        System.out.println("Array ordenado:");
        for (int numero : arrayDesordenado) {
            System.out.print(numero + " ");
        }
    }
}
