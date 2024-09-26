package Clase5;

import java.util.ArrayList;
import java.util.List;

public class Actividad2 {
    private int[][] matrizAdyacencia;
    private int numVertices;

    public Actividad2(int numVertices) {
        this.numVertices = numVertices;
        matrizAdyacencia = new int[numVertices][numVertices];
    }

    public void agregarArista(int origen, int destino) {
        if (origen >= 0 && origen < numVertices && destino >= 0 && destino < numVertices) {
            matrizAdyacencia[origen][destino] = 1;
        }
    }

    public void eliminarArista(int origen, int destino) {
        if (origen >= 0 && origen < numVertices && destino >= 0 && destino < numVertices) {
            matrizAdyacencia[origen][destino] = 0;
        }
    }

    public boolean verificarArista(int origen, int destino) {
        if (origen >= 0 && origen < numVertices && destino >= 0 && destino < numVertices) {
            return matrizAdyacencia[origen][destino] == 1;
        }
        return false;
    }

    public List<Integer> listarAdyacentes(int vertice) {
        List<Integer> adyacentes = new ArrayList<>();
        if (vertice >= 0 && vertice < numVertices) {
            for (int i = 0; i < numVertices; i++) {
                if (matrizAdyacencia[vertice][i] == 1) {
                    adyacentes.add(i);
                }
            }
        }
        return adyacentes;
    }

    public int contarGradoSalida(int vertice) {
        int gradoSalida = 0;
        if (vertice >= 0 && vertice < numVertices) {
            for (int i = 0; i < numVertices; i++) {
                if (matrizAdyacencia[vertice][i] == 1) {
                    gradoSalida++;
                }
            }
        }
        return gradoSalida;
    }

    public int contarGradoEntrada(int vertice) {
        int gradoEntrada = 0;
        if (vertice >= 0 && vertice < numVertices) {
            for (int i = 0; i < numVertices; i++) {
                if (matrizAdyacencia[i][vertice] == 1) {
                    gradoEntrada++;
                }
            }
        }
        return gradoEntrada;
    }

    public void mostrarMatrizAdyacencia() {
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print(matrizAdyacencia[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Actividad2 grafo = new Actividad2(4);

        grafo.agregarArista(0, 1);
        grafo.agregarArista(0, 2);
        grafo.agregarArista(1, 2);
        grafo.agregarArista(2, 3);

        System.out.println("Matriz de adyacencia:");
        grafo.mostrarMatrizAdyacencia();

        System.out.println("\nVerificar si existe una arista entre 0 y 2: " + grafo.verificarArista(0, 2));
        System.out.println("Verificar si existe una arista entre 2 y 0: " + grafo.verificarArista(2, 0));

        System.out.println("\nVértices adyacentes a 0: " + grafo.listarAdyacentes(0));

        System.out.println("\nGrado de salida de 0: " + grafo.contarGradoSalida(0));
        System.out.println("Grado de entrada de 2: " + grafo.contarGradoEntrada(2));

        grafo.eliminarArista(0, 2);
        System.out.println("\nMatriz de adyacencia después de eliminar la arista entre 0 y 2:");
        grafo.mostrarMatrizAdyacencia();
    }
}