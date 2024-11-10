package clase11;

import java.util.*;

public class grafo {
    private Map<almacen, List<almacen>> adjList;

    // Constructor
    public grafo() {
        adjList = new HashMap<>();
    }

    public void agregarAlmacen(almacen almacen) {
        adjList.putIfAbsent(almacen, new ArrayList<>());
    }

    public void conectarAlmacenes(almacen almacen1, almacen almacen2) {
        adjList.get(almacen1).add(almacen2);
        adjList.get(almacen2).add(almacen1);  
    }

    public void dfs(almacen inicio) {
        Set<almacen> visitados = new HashSet<>();
        System.out.println("DFS desde el almacén " + inicio.getNombre() + ":");
        dfsRecursivo(inicio, visitados);
        System.out.println();
    }

    private void dfsRecursivo(almacen almacen, Set<almacen> visitados) {
        if (!visitados.contains(almacen)) {
            visitados.add(almacen);
            System.out.print(almacen.getNombre() + " ");
            for (almacen vecino : adjList.get(almacen)) {
                dfsRecursivo(vecino, visitados);
            }
        }
    }

    public void bfs(almacen inicio) {
        Set<almacen> visitados = new HashSet<>();
        Queue<almacen> queue = new LinkedList<>();
        queue.add(inicio);
        visitados.add(inicio);

        System.out.println("BFS desde el almacén " + inicio.getNombre() + ":");
        while (!queue.isEmpty()) {
            almacen almacen = queue.poll();
            System.out.print(almacen.getNombre() + " ");
            for (almacen vecino : adjList.get(almacen)) {
                if (!visitados.contains(vecino)) {
                    visitados.add(vecino);
                    queue.add(vecino);
                }
            }
        }
        System.out.println();
    }

    public void mostrarRed() {
        for (almacen almacen : adjList.keySet()) {
            System.out.print(almacen.getNombre() + " está conectado a: ");
            for (almacen vecino : adjList.get(almacen)) {
                System.out.print(vecino.getNombre() + " ");
            }
            System.out.println();
        }
    }
}
