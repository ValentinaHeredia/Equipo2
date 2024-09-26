package clase4;

import java.util.*;

public class Ejercicio3 {

    public static class Mercancia {
        String nombre;
        int peso;
        int valor;
        double valorPorPeso;

        public Mercancia(String nombre, int peso, int valor) {
            this.nombre = nombre;
            this.peso = peso;
            this.valor = valor;
            this.valorPorPeso = (double) valor / peso;  // Relación valor/peso
        }
    }

    public static List<Mercancia> cargarCamion(Mercancia[] Mercancias, int capacidadCamion) {
        Arrays.sort(Mercancias, (m1, m2) -> Double.compare(m2.valorPorPeso, m1.valorPorPeso));
        List<Mercancia> Resultado = new ArrayList<>();
        int capacidadRestante = capacidadCamion;

        for (int i = Mercancias.length-1; i >= 0; i--) {
        
            if (Mercancias[i].peso <= capacidadRestante) {
                while (Mercancias[i].peso <= capacidadRestante) {
                    capacidadRestante -= Mercancias[i].peso;
                    Resultado.add(new Mercancia(Mercancias[i].nombre, Mercancias[i].peso, Mercancias[i].valor));
                }
            }
            if (capacidadRestante > 0 && i == 0) {
                int pesoFraccion = capacidadRestante;
                int valorFraccion = (int) (Mercancias[i].valor * ((double) capacidadRestante / Mercancias[i].peso));
                Resultado.add(new Mercancia(Mercancias[i].nombre, pesoFraccion, valorFraccion));
                capacidadRestante = 0; 
            }

            if (capacidadRestante == 0) {
                break; 
            }
        }
        return Resultado;
    }

    public static void main(String[] args) {
        // Ejemplo de mercancías
        Mercancia[] Mercancias = {
            new Mercancia("Lechuga", 50, 100),
            new Mercancia("Tomate", 30, 70),
            new Mercancia("Perejil", 10, 25)
        };
        int capacidadCamion = 343;  // Capacidad del camión

        List<Mercancia> Resultado = cargarCamion(Mercancias, capacidadCamion);
        System.out.println("Artículos cargados en el camión:");

        for (Mercancia mercancia : Resultado) {
            System.out.println("Nombre: " + mercancia.nombre + ", Peso: " + mercancia.peso + ", Valor: " + mercancia.valor);
        }
    }
}
