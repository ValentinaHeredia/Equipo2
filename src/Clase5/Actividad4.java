package Clase5;

import java.util.*;

class Camino {
    int destino;
    int tiempo;

    public Camino(int destino, int tiempo) {
        this.destino = destino;
        this.tiempo = tiempo;
    }
}

class Grafos {
    private int numVertices;
    private List<List<Camino>> listaAdyacencia;

    // Constructor para inicializar el grafo
    public Grafos(int numVertices) {
        this.numVertices = numVertices;
        listaAdyacencia = new ArrayList<>();
        for (int i = 0; i < numVertices; i++) {
            listaAdyacencia.add(new ArrayList<>());
        }
    }

    // Agregar una carretera entre dos centros de distribución con un tiempo de viaje
    public void agregarArista(int origen, int destino, int tiempo) {
        listaAdyacencia.get(origen).add(new Camino(destino, tiempo));
    }

    // Aplicar el algoritmo de Dijkstra para encontrar el tiempo mínimo de entrega
    public int[] dijkstra(int fuente) {
        int[] tiempos = new int[numVertices];
        boolean[] visitado = new boolean[numVertices];
        Arrays.fill(tiempos, Integer.MAX_VALUE);
        tiempos[fuente] = 0;

        PriorityQueue<int[]> colaPrioridad = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        colaPrioridad.add(new int[]{fuente, 0}); // {vértice, tiempo}

        while (!colaPrioridad.isEmpty()) {
            int[] actual = colaPrioridad.poll();
            int vertice = actual[0];
            int tiempoAcumulado = actual[1];

            if (visitado[vertice]) continue;
            visitado[vertice] = true;

            for (Camino camino : listaAdyacencia.get(vertice)) {
                if (!visitado[camino.destino]) {
                    int nuevoTiempo = tiempoAcumulado + camino.tiempo;
                    if (nuevoTiempo < tiempos[camino.destino]) {
                        tiempos[camino.destino] = nuevoTiempo;
                        colaPrioridad.add(new int[]{camino.destino, nuevoTiempo});
                    }
                }
            }
        }
        return tiempos;
    }
}

public class Actividad4 {
    public static void main(String[] args) {
        // Crear el grafo con 5 centros de distribución
        Grafos grafos = new Grafos(5);

        // Agregar carreteras entre centros con sus respectivos tiempos de viaje
        grafos.agregarArista(0, 1, 10);
        grafos.agregarArista(0, 2, 5);
        grafos.agregarArista(1, 2, 2);
        grafos.agregarArista(1, 3, 1);
        grafos.agregarArista(2, 1, 3);
        grafos.agregarArista(2, 3, 9);
        grafos.agregarArista(2, 4, 2);
        grafos.agregarArista(3, 4, 4);
        grafos.agregarArista(4, 3, 6);

        // Calcular el tiempo mínimo de entrega desde el centro de distribución principal (vértice 0)
        int[] tiemposMinimos = grafos.dijkstra(0);

        // Mostrar los resultados
        System.out.println("Tiempo mínimo de entrega desde el centro de distribución principal:");
        for (int i = 0; i < tiemposMinimos.length; i++) {
            if (tiemposMinimos[i] == Integer.MAX_VALUE) {
                System.out.println("Centro de distribución " + i + ": No es alcanzable");
            } else {
                System.out.println("Centro de distribución " + i + ": " + tiemposMinimos[i] + " minutos");
            }
        }
    }
}
