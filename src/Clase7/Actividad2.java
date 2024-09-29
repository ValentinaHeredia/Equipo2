package Clase7;

public class Actividad2 {

    final static int INF = 99999;


    public static void floydWarshall(int[][] grafo, int n) {

        int[][] distancias = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                distancias[i][j] = grafo[i][j];
            }
        }

        for (int k = 0; k < n; k++) {

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (distancias[i][k] != INF && distancias[k][j] != INF && distancias[i][k] + distancias[k][j] < distancias[i][j]) {
                        distancias[i][j] = distancias[i][k] + distancias[k][j];
                    }
                }
            }
        }


        if (detectarCicloNegativo(distancias, n)) {
            System.out.println("El grafo contiene ciclos negativos.");
        } else {
            System.out.println("El grafo no contiene ciclos negativos.");
        }


        imprimirSolucion(distancias, n);
    }

    public static boolean detectarCicloNegativo(int[][] distancias, int n) {
        for (int i = 0; i < n; i++) {

            if (distancias[i][i] < 0) {
                return true;
            }
        }
        return false;
    }

    public static void imprimirSolucion(int[][] distancias, int n) {
        System.out.println("Matriz de distancias más cortas entre cada par de nodos:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (distancias[i][j] == INF) {
                    System.out.print("INF ");
                } else {
                    System.out.print(distancias[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 4;

        int[][] grafo = {
                {0, 2, INF, 5},
                {INF, 0, 3, 4},
                {INF, INF, 0, 2},
                {INF, -2, INF, 0}
        };

        floydWarshall(grafo, n);
    }
}
