package Clase7;

public class Actividad1 {

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

        imprimirSolucion(distancias, n);
    }


    public static void imprimirSolucion(int[][] distancias, int n) {
        System.out.println("Matriz de distancias más cortas entre cada par de vertices:");
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
        int n = 5;  // Número de nodos

        int[][] grafo = {
                {0, 2, INF, 6, 1},
                {INF, 0, INF, 4, INF},
                {INF, INF, 0, INF, 2},
                {INF, INF, 2, 0, 4},
                {0, INF, 5, INF, 2}
        };

        floydWarshall(grafo, n);
    }
}
