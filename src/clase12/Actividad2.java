package clase12;


public class Actividad2 {
    public static void main(String[] args) {
        // Creación de los destinos
        Nodo A = new Nodo("A");
        Nodo B = new Nodo("B");
        Nodo C = new Nodo("C");
        Nodo D = new Nodo("D");

        // Creación del grafo
        Grafo grafo = new Grafo();

        // Agregar vuelos (aristas con precio)
        grafo.agregarVuelo(A, B, 100);
        grafo.agregarVuelo(A, C, 200);
        grafo.agregarVuelo(B, D, 150);
        grafo.agregarVuelo(C, D, 100);
        grafo.agregarVuelo(B, C, 50);

        // Crear el objeto UCS
        UCS ucs = new UCS(grafo);

        // Encontrar la ruta más barata desde A a D
        ucs.encontrarRutaMinima(A, D);
    }
}