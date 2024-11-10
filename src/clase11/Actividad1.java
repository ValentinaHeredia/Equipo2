package clase11;
import java.util.*;

public class Actividad1 {
    private Map<Integer, List<Integer>> graph;

    public Actividad1() {
        graph = new HashMap<>();
    }

    // Método para agregar las conexiones entre nodos
    public void addEdge(int node, int neighbor) {
        if (!graph.containsKey(node)) {
            graph.put(node, new ArrayList<>());
        }
        graph.get(node).add(neighbor);
    }

    // Método para realizar el DFS
    public void dfs(int start) {
        Set<Integer> visited = new HashSet<>();
        dfsUtil(start, visited);
    }

    // Función auxiliar para DFS
    private void dfsUtil(int node, Set<Integer> visited) {
        // Marca el nodo como visitado
        visited.add(node);
        System.out.print(node + " "); // Imprime el nodo visitado

        // Recursivamente visita todos los nodos adyacentes
        for (int neighbor : graph.getOrDefault(node, new ArrayList<>())) {
            if (!visited.contains(neighbor)) {
                dfsUtil(neighbor, visited);
            }
        }
    }

    public static void main(String[] args) {
        Actividad1 dfs = new Actividad1();

        // Agregar los bordes al grafo
        dfs.addEdge(0, 1);
        dfs.addEdge(0, 2);
        dfs.addEdge(1, 0);
        dfs.addEdge(1, 3);
        dfs.addEdge(1, 4);
        dfs.addEdge(2, 0);
        dfs.addEdge(2, 5);
        dfs.addEdge(3, 1);
        dfs.addEdge(3, 6);
        dfs.addEdge(4, 1);
        dfs.addEdge(4, 7);
        dfs.addEdge(4, 8);
        dfs.addEdge(5, 2);
        dfs.addEdge(7, 4);
        dfs.addEdge(8, 4);

        // Llamar al DFS desde el nodo 0
        System.out.println("DFS desde el nodo 0:");
        dfs.dfs(0);
    }
}
