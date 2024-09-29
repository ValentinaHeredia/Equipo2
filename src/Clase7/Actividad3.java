package Clase7;

import java.util.Scanner;

public class Actividad3 {

    final static int INF = 99999;

    public static void floydWarshall(int[][] grafo, int n) {

        int[][] distancias = new int[n][n];
        int[][] predecesor = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                distancias[i][j] = grafo[i][j];
                if (grafo[i][j] != INF && i != j) {
                    predecesor[i][j] = i;
                } else {
                    predecesor[i][j] = -1;
                }
            }
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (distancias[i][k] != INF && distancias[k][j] != INF && distancias[i][k] + distancias[k][j] < distancias[i][j]) {
                        distancias[i][j] = distancias[i][k] + distancias[k][j];
                        predecesor[i][j] = predecesor[k][j];
                    }
                }
            }
        }

        imprimirSolucion(distancias, n);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el nodo origen (0 a " + (n - 1) + "): ");
        int origen = scanner.nextInt();
        System.out.print("Introduce el nodo destino (0 a " + (n - 1) + "): ");
        int destino = scanner.nextInt();

        if (distancias[origen][destino] == INF) {
            System.out.println("No existe un camino entre el nodo " + origen + " y el nodo " + destino);
        } else {
            System.out.println("El camino más corto entre el nodo " + origen + " y el nodo " + destino + " tiene una distancia de " + distancias[origen][destino] + " minutos.");
            System.out.print("El camino es: ");
            imprimirCamino(origen, destino, predecesor);
            System.out.println(destino);
        }
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

    public static void imprimirCamino(int origen, int destino, int[][] predecesor) {
        if (predecesor[origen][destino] == -1) {
            System.out.print("No hay camino.");
            return;
        }
        if (origen != destino) {
            imprimirCamino(origen, predecesor[origen][destino], predecesor);
        }
        System.out.print(predecesor[origen][destino] + " -> ");
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
