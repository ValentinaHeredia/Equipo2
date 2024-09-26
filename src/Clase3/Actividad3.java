package Clase3;

public class Actividad3 {

    static class Cliente {
        int id;
        String nombre;
        int scoring;

        public Cliente(int id, String nombre, int scoring) {
            this.id = id;
            this.nombre = nombre;
            this.scoring = scoring;
        }

        public String toString() {
            return "Cliente{id=" + id + ", nombre='" + nombre + "', scoring=" + scoring + '}';
        }
    }

    public static void main(String[] args) {
        Cliente[] listaClientes = {
                new Cliente(1, "Alice", 75),
                new Cliente(2, "Bob", 85),
                new Cliente(3, "Charlie", 65),
                new Cliente(4, "David", 95),
                new Cliente(5, "Eve", 80)
        };

        Cliente[] dosMaximos = encontrarDosMaximos(listaClientes, 0, listaClientes.length - 1);
        System.out.println("Cliente con el scoring máximo: " + dosMaximos[0]);
        System.out.println("Cliente con el segundo scoring máximo: " + dosMaximos[1]);
    }

    private static Cliente[] encontrarDosMaximos(Cliente[] listaClientes, int inicio, int fin) {
        if (inicio == fin) {
            return new Cliente[]{listaClientes[inicio], null};
        }

        int mitad = (inicio + fin) / 2;

        Cliente[] maximosIzquierda = encontrarDosMaximos(listaClientes, inicio, mitad);
        Cliente[] maximosDerecha = encontrarDosMaximos(listaClientes, mitad + 1, fin);

        Cliente max1Izquierda = maximosIzquierda[0];
        Cliente max2Izquierda = maximosIzquierda[1];
        Cliente max1Derecha = maximosDerecha[0];
        Cliente max2Derecha = maximosDerecha[1];

        Cliente max1;
        Cliente max2;

        if (max1Izquierda.scoring > max1Derecha.scoring) {
            max1 = max1Izquierda;
            max2 = max2Izquierda != null ? (max2Izquierda.scoring > max1Derecha.scoring ? max2Izquierda : max1Derecha) : max1Derecha;
        } else {
            max1 = max1Derecha;
            max2 = max2Derecha != null ? (max2Derecha.scoring > max1Izquierda.scoring ? max2Derecha : max1Izquierda) : max1Izquierda;
        }

        return new Cliente[]{max1, max2};
    }
}

//Complejidad O(n \log n)
