package Clase2;

public class Actividad3 {

    // Método para realizar el ordenamiento QuickSort
    public static void ordenarQuickSort(int[] array, int bajo, int alto) {
        if (bajo < alto) {
            // Encuentra el índice de partición
            int indiceParticion = particionar(array, bajo, alto);

            // Ordena los elementos antes y después de la partición
            ordenarQuickSort(array, bajo, indiceParticion - 1);
            ordenarQuickSort(array, indiceParticion + 1, alto);
        }
    }

    // Método para particionar el arreglo
    private static int particionar(int[] array, int bajo, int alto) {
        int pivote = array[alto]; // Se elige el último elemento como pivote
        int i = (bajo - 1); // Índice del elemento más pequeño

        for (int j = bajo; j < alto; j++) {
            // Si el elemento actual es menor o igual al pivote
            if (array[j] <= pivote) {
                i++;
                // Intercambia arreglo[i] y arreglo[j]
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        // Intercambia el pivote con el elemento en la posición i+1
        int temp = array[i + 1];
        array[i + 1] = array[alto];
        array[alto] = temp;

        return i + 1; // Retorna el índice de la partición
    }

    public static void main(String[] args) {
        int[] array = { 3, 6, 8, 10, 1, 2, 1 };
        System.out.println("Array antes de ordenar:");
        for (int numero : array) {
            System.out.print(numero + " ");
        }
        System.out.println();

        ordenarQuickSort(array, 0, array.length - 1);

        System.out.println("Array después de ordenar:");
        for (int numero : array) {
            System.out.print(numero + " ");
        }
        System.out.println();
    }
}
