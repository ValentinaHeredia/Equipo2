package Clase3;

public class Actividad1 {


    public static class Cliente {
        int id;
        String nombre;
        int scoring;

        public Cliente(int id, String nombre, int scoring) {
            this.id = id;
            this.nombre = nombre;
            this.scoring = scoring;
        }
    }

    public static void main(String[] args) {
        Cliente[] clientes = {
                new Cliente(1, "Alice", 85),
                new Cliente(2, "Bob", 95),
                new Cliente(3, "Charlie", 75),
                new Cliente(4, "Diana", 90)
        };

        Cliente clienteMaximo = encontrarClienteMaximo(clientes, 0, clientes.length - 1);
        System.out.println("Cliente con el scoring máximo: " + clienteMaximo.nombre + " (Scoring: " + clienteMaximo.scoring + ")");
    }

    private static Cliente encontrarClienteMaximo(Cliente[] clientes, int inicio, int fin) {
        if (inicio == fin) {
            return clientes[inicio];
        }

        int mitad = (inicio + fin) / 2;

        Cliente maxClienteIzquierda = encontrarClienteMaximo(clientes, inicio, mitad);
        Cliente maxClienteDerecha = encontrarClienteMaximo(clientes, mitad + 1, fin);

        if (maxClienteIzquierda.scoring > maxClienteDerecha.scoring) {
            return maxClienteIzquierda;
        } else {
            return maxClienteDerecha;
        }
    }
}

//Complejidad O(n)
