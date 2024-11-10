package clase11;

import java.util.*;


public class Actividad2 {
    public static void bfs(int startNode, Map<Integer, List<Integer>> graph) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(startNode);
        visited.add(startNode);

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            System.out.print(currentNode + " ");

            for (int neighbor : graph.get(currentNode)) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        
        for (int i = 0; i < 9; i++) {
            graph.put(i, new ArrayList<>()); 
        }

        graph.get(0).addAll(Arrays.asList(1, 2));
        graph.get(1).addAll(Arrays.asList(0, 3, 4));
        graph.get(2).addAll(Arrays.asList(0, 5));
        graph.get(5).addAll(Arrays.asList(2));
        graph.get(3).addAll(Arrays.asList(1, 6));
        graph.get(4).addAll(Arrays.asList(1, 7, 8));
        graph.get(7).addAll(Arrays.asList(4));
        graph.get(8).addAll(Arrays.asList(4));
        
        System.out.println("BFS desde el nodo 0:");
        bfs(0, graph);
    }
}
