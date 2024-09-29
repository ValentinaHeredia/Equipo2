package clase6;

public class Ejercicio1 {
    public static int optimizarCapacidad(int[] peso, int[] valor, int capacidad) {
        int n = peso.length;
        int[][] tabla = new int[n + 1][capacidad + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= capacidad; j++) {
                if (peso[i - 1] <= j) {
                    tabla[i][j] = Math.max(tabla[i - 1][j], tabla[i - 1][j - peso[i - 1]] + valor[i - 1]);
                } else {
                    tabla[i][j] = tabla[i - 1][j];
                }
            }
        }

        return tabla[n][capacidad];
    }

    public static void main(String[] args) {
        int[] peso = {3, 4, 2};
        int[] valor = {4, 5, 3};
        int capacidad = 6;

        int rendimientoMaximo = optimizarCapacidad(peso, valor, capacidad);
        System.out.println("Rendimiento máximo de la capacidad: " + capacidad + " es: " + rendimientoMaximo);
    }
}