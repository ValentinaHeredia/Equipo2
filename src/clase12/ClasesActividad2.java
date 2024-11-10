package clase12;

import java.util.*;

class Nodo {
    String nombre;
    Nodo(String nombre) {
        this.nombre = nombre;
    }
}

class Vuelo {
    Nodo destino;
    int precio;

    Vuelo(Nodo destino, int precio) {
        this.destino = destino;
        this.precio = precio;
    }
}

class Grafo {
    Map<Nodo, List<Vuelo>> adjacencias;

    Grafo() {
        adjacencias = new HashMap<>();
    }

    void agregarVuelo(Nodo origen, Nodo destino, int precio) {
        adjacencias.putIfAbsent(origen, new ArrayList<>());
        adjacencias.get(origen).add(new Vuelo(destino, precio));
    }

    List<Vuelo> obtenerVuelosDesde(Nodo nodo) {
        return adjacencias.getOrDefault(nodo, new ArrayList<>());
    }
}

class UCS {
    private Grafo grafo;

    UCS(Grafo grafo) {
        this.grafo = grafo;
    }

    public List<Nodo> encontrarRutaMinima(Nodo origen, Nodo destino) {
        PriorityQueue<Map.Entry<Nodo, Integer>> colaPrioridad = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        Map<Nodo, Integer> costos = new HashMap<>();
        Map<Nodo, Nodo> padres = new HashMap<>();
        Set<Nodo> visitados = new HashSet<>();

        colaPrioridad.offer(new AbstractMap.SimpleEntry<>(origen, 0));
        costos.put(origen, 0);

        while (!colaPrioridad.isEmpty()) {
            Map.Entry<Nodo, Integer> actual = colaPrioridad.poll();
            Nodo nodoActual = actual.getKey();
            int costoActual = actual.getValue();

            if (visitados.contains(nodoActual)) continue;
            visitados.add(nodoActual);

            if (nodoActual.equals(destino)) {
                List<Nodo> ruta = new ArrayList<>();
                int costoTotal = costoActual;
                while (nodoActual != null) {
                    ruta.add(nodoActual);
                    nodoActual = padres.get(nodoActual);
                }
                Collections.reverse(ruta);

                System.out.println("Ruta más barata:");
                for (int i = 0; i < ruta.size(); i++) {
                    System.out.print(ruta.get(i).nombre);
                    if (i < ruta.size() - 1) System.out.print(" -> ");
                }
                System.out.println();
                System.out.println("Costo total: " + costoTotal);
                return ruta;
            }

            for (Vuelo vuelo : grafo.obtenerVuelosDesde(nodoActual)) {
                Nodo destinoVuelo = vuelo.destino;
                int nuevoCosto = costoActual + vuelo.precio;

                if (!costos.containsKey(destinoVuelo) || nuevoCosto < costos.get(destinoVuelo)) {
                    costos.put(destinoVuelo, nuevoCosto);
                    padres.put(destinoVuelo, nodoActual);
                    colaPrioridad.offer(new AbstractMap.SimpleEntry<>(destinoVuelo, nuevoCosto));
                }
            }
        }

        System.out.println("No hay ruta disponible.");
        return new ArrayList<>();
    }
}