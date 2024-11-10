package clase11;

import java.util.*;

public class Red {

    private Map<Usuario, List<Usuario>> adjList;

    public Red() {
        adjList = new HashMap<>();
    }
    public void agregarUsuario(Usuario usuario) {
        adjList.putIfAbsent(usuario, new ArrayList<>());
    }

    public void conectarAmigos(Usuario usuario1, Usuario usuario2) {
        adjList.get(usuario1).add(usuario2);
        adjList.get(usuario2).add(usuario1); 
    }

    public void dfs(Usuario inicio) {
        Set<Usuario> visitados = new HashSet<>();
        System.out.println("Recorrido DFS desde " + inicio.getNombre() + ":");
        dfsRecursivo(inicio, visitados);
        System.out.println();
    }

    private void dfsRecursivo(Usuario usuario, Set<Usuario> visitados) {
        if (!visitados.contains(usuario)) {
            visitados.add(usuario);
            System.out.print(usuario.getNombre() + " ");
            for (Usuario amigo : adjList.get(usuario)) {
                dfsRecursivo(amigo, visitados);
            }
        }
    }

    public void bfs(Usuario inicio) {
        Set<Usuario> visitados = new HashSet<>();
        Queue<Usuario> queue = new LinkedList<>();
        queue.add(inicio);
        visitados.add(inicio);

        System.out.println("Recorrido BFS desde " + inicio.getNombre() + ":");
        while (!queue.isEmpty()) {
            Usuario usuario = queue.poll();
            System.out.print(usuario.getNombre() + " ");
            for (Usuario amigo : adjList.get(usuario)) {
                if (!visitados.contains(amigo)) {
                    visitados.add(amigo);
                    queue.add(amigo);
                }
            }
        }
        System.out.println();
    }

    public void mostrarRed() {
        for (Usuario usuario : adjList.keySet()) {
            System.out.print(usuario.getNombre() + " tiene como amigos: ");
            for (Usuario amigo : adjList.get(usuario)) {
                System.out.print(amigo.getNombre() + " ");
            }
            System.out.println();
        }
    }
}
