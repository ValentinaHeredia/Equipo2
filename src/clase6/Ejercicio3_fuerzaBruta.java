package clase6;

import java.util.ArrayList;

public class Ejercicio3_fuerzaBruta {
    public static class Proyecto {
        int Costo;
        int Beneficio;

        public Proyecto(int costo, int beneficio) {
            Costo = costo;
            Beneficio = beneficio;
        }

        @Override
        public String toString() {
            return "Costo: " + Costo + ", Beneficio: " + Beneficio;
        }
    }

    public static ArrayList<Proyecto> seleccionProyectos(Proyecto[] proyectosDisponibles, int presupuesto) {
        ArrayList<Proyecto> mejorSeleccion = new ArrayList<>();
        int maxBeneficio = 0;
        int totalProyectos = proyectosDisponibles.length;

        for (int i = 0; i < (1 << totalProyectos); i++) {
            ArrayList<Proyecto> seleccionados = new ArrayList<>();
            int costoTotal = 0;
            int beneficioTotal = 0;

            for (int j = 0; j < totalProyectos; j++) {
                if ((i & (1 << j)) != 0) {
                    costoTotal += proyectosDisponibles[j].Costo;
                    beneficioTotal += proyectosDisponibles[j].Beneficio;
                    seleccionados.add(proyectosDisponibles[j]);
                }
            }

            if (costoTotal <= presupuesto && beneficioTotal > maxBeneficio) {
                maxBeneficio = beneficioTotal;
                // Crear una copia de la lista seleccionados
                mejorSeleccion = new ArrayList<>(seleccionados);
            }
        }

        return mejorSeleccion;
    }

    public static void main(String[] args) {
        Proyecto[] proyectosDisponibles = {
            new Proyecto(10, 100),
            new Proyecto(15, 200),
            new Proyecto(20, 150),
            new Proyecto(25, 300)
        };
        int presupuesto = 40;

        ArrayList<Proyecto> resultado = seleccionProyectos(proyectosDisponibles, presupuesto);
        System.out.println("Proyectos seleccionados:");
        for (Proyecto p : resultado) {
            System.out.println(p);
        }
    }
}
