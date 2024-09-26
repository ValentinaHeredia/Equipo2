package Clase3;

public class Actividad2 {

    public static void main(String[] args) {
        int[] numeros = {3, 5, 1, 8, 7, 9, 4, 2};
        int[] resultado = encontrarDosMaximos(numeros, 0, numeros.length - 1);
        System.out.println("Los dos números mayores son: " + resultado[0] + " y " + resultado[1]);
    }

    private static int[] encontrarDosMaximos(int[] numeros, int inicio, int fin) {
        if (inicio == fin) {
            return new int[] {numeros[inicio], Integer.MIN_VALUE};
        }

        int mitad = (inicio + fin) / 2;

        int[] maximosIzquierda = encontrarDosMaximos(numeros, inicio, mitad);
        int[] maximosDerecha = encontrarDosMaximos(numeros, mitad + 1, fin);

        int max1Izquierda = maximosIzquierda[0];
        int max2Izquierda = maximosIzquierda[1];
        int max1Derecha = maximosDerecha[0];
        int max2Derecha = maximosDerecha[1];

        int max1;
        int max2;

        if (max1Izquierda > max1Derecha) {
            max1 = max1Izquierda;
            max2 = Math.max(max2Izquierda, max1Derecha);
        } else {
            max1 = max1Derecha;
            max2 = Math.max(max2Derecha, max1Izquierda);
        }

        return new int[] {max1, max2};
    }
}

//Complejidad O(n \log n)