package clase6;

import java.util.*;

public class Ejercicio3_Greedy {
    public static class Proyecto {
        int Costo;
        int Beneficio;

        public Proyecto(int costo, int beneficio) {
            Costo = costo;
            Beneficio = beneficio;
        }

        @Override
        public String toString() { // Sobrescribir el método toString
            return "Proyecto { Costo: " + Costo + ", Beneficio: " + Beneficio + " }";
        }
    }

    public static ArrayList<Proyecto> seleccionProyectos(Proyecto[] proyectosDisponibles, int presupuesto) {
        Arrays.sort(proyectosDisponibles, (c1, c2) -> Integer.compare(c1.Costo, c2.Costo));
        ArrayList<Proyecto> seleccionados = new ArrayList<>();
        int presupuestoDisponible = presupuesto;

        for (int i = proyectosDisponibles.length-1; i >= 0; i--) {
            if (proyectosDisponibles[i].Costo <= presupuestoDisponible) {
                seleccionados.add(proyectosDisponibles[i]);
                presupuestoDisponible -= proyectosDisponibles[i].Costo;
            }
        }
        return seleccionados;
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
        System.out.println("Proyectos seleccionados: " + resultado);
    }
}
