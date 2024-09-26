package Clase5;

import java.util.*;

class Arista implements Comparable<Arista> {
    int origen, destino, costo;

    public Arista(int origen, int destino, int costo) {
        this.origen = origen;
        this.destino = destino;
        this.costo = costo;
    }

    @Override
    public int compareTo(Arista otra) {
        return this.costo - otra.costo;
    }

    @Override
    public String toString() {
        return "De " + origen + " a " + destino + " con costo: " + costo;
    }
}

class Grafo {
    private int numVertices;
    private List<List<Arista>> listaAdyacencia;

    public Grafo(int numVertices) {
        this.numVertices = numVertices;
        listaAdyacencia = new ArrayList<>();
        for (int i = 0; i < numVertices; i++) {
            listaAdyacencia.add(new ArrayList<>());
        }
    }

    public void agregarArista(int origen, int destino, int costo) {
        listaAdyacencia.get(origen).add(new Arista(origen, destino, costo));
        listaAdyacencia.get(destino).add(new Arista(destino, origen, costo)); // Grafo no dirigido
    }

    public List<Arista> primMST() {
        boolean[] visitado = new boolean[numVertices];
        PriorityQueue<Arista> colaPrioridad = new PriorityQueue<>();
        List<Arista> mst = new ArrayList<>();

        visitado[0] = true;
        colaPrioridad.addAll(listaAdyacencia.get(0));

        while (!colaPrioridad.isEmpty()) {
            Arista aristaActual = colaPrioridad.poll();

            if (visitado[aristaActual.destino]) {
                continue;
            }

            mst.add(aristaActual);
            int vertice = aristaActual.destino;
            visitado[vertice] = true;

            for (Arista arista : listaAdyacencia.get(vertice)) {
                if (!visitado[arista.destino]) {
                    colaPrioridad.add(arista);
                }
            }
        }
        return mst;
    }

    public int calcularCostoTotal(List<Arista> mst) {
        int costoTotal = 0;
        for (Arista arista : mst) {
            costoTotal += arista.costo;
        }
        return costoTotal;
    }

    public void mostrarMST(List<Arista> mst) {
        System.out.println("Conexiones óptimas:");
        for (Arista arista : mst) {
            System.out.println(arista);
        }
    }
}

public class Actividad3 {
    public static void main(String[] args) {
        Grafo grafo = new Grafo(5);

        grafo.agregarArista(0, 1, 10);
        grafo.agregarArista(0, 2, 20);
        grafo.agregarArista(1, 2, 30);
        grafo.agregarArista(1, 3, 5);
        grafo.agregarArista(2, 3, 15);
        grafo.agregarArista(3, 4, 10);
        grafo.agregarArista(2, 4, 25);

        List<Arista> mst = grafo.primMST();

        grafo.mostrarMST(mst);

        int costoTotal = grafo.calcularCostoTotal(mst);
        System.out.println("Costo total del Árbol de Recubrimiento Mínimo: " + costoTotal);
    }
}
