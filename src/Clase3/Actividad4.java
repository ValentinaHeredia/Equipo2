package Clase3;

import java.util.Arrays;

public class Actividad4 {

    public static void main(String[] args) {
        int[] lista = {15, 3, 9, 8, 23, 5, 7, 19, 2, 20, 13, 10, 17, 6};
        int n = 5;

        int[] nMayores = encontrarNMayores(lista, 0, lista.length - 1, n);

        System.out.println("Los " + n + " elementos más grandes son:");
        for (int num : nMayores) {
            System.out.println(num);
        }
    }

    private static int[] encontrarNMayores(int[] lista, int inicio, int fin, int n) {
        if (fin - inicio + 1 <= n) {
            int[] sublista = Arrays.copyOfRange(lista, inicio, fin + 1);
            Arrays.sort(sublista);
            return invertirArray(Arrays.copyOfRange(sublista, sublista.length - n, sublista.length));
        }

        int mitad = (inicio + fin) / 2;
        int[] mayoresIzquierda = encontrarNMayores(lista, inicio, mitad, n);
        int[] mayoresDerecha = encontrarNMayores(lista, mitad + 1, fin, n);

        return combinarYSeleccionarNMayores(mayoresIzquierda, mayoresDerecha, n);
    }

    private static int[] combinarYSeleccionarNMayores(int[] izq, int[] der, int n) {
        int[] combinados = new int[izq.length + der.length];
        System.arraycopy(izq, 0, combinados, 0, izq.length);
        System.arraycopy(der, 0, combinados, izq.length, der.length);

        Arrays.sort(combinados);
        return invertirArray(Arrays.copyOfRange(combinados, combinados.length - n, combinados.length));
    }

    private static int[] invertirArray(int[] array) {
        int[] invertido = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            invertido[i] = array[array.length - 1 - i];
        }
        return invertido;
    }
}

