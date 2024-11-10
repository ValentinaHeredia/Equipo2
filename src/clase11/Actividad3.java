package clase11;

public class Actividad3 {
    public static void main(String[] args) {

        almacen almacen1 = new almacen(1, "Almacen A");
        almacen almacen2 = new almacen(2, "Almacen B");
        almacen almacen3 = new almacen(3, "Almacen C");
        almacen almacen4 = new almacen(4, "Almacen D");
        almacen almacen5 = new almacen(5, "Almacen E");

        grafo grafo = new grafo();

        grafo.agregarAlmacen(almacen1);
        grafo.agregarAlmacen(almacen2);
        grafo.agregarAlmacen(almacen3);
        grafo.agregarAlmacen(almacen4);
        grafo.agregarAlmacen(almacen5);

        grafo.conectarAlmacenes(almacen1, almacen2);
        grafo.conectarAlmacenes(almacen1, almacen3);
        grafo.conectarAlmacenes(almacen2, almacen4);
        grafo.conectarAlmacenes(almacen3, almacen5);

        grafo.mostrarRed();

        grafo.dfs(almacen1);

        grafo.bfs(almacen1);
    }
}
