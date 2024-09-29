package clase6;

public class Ejercicio3_Dinamico {
    public static int seleccionProyectos(int[] costos, int[] beneficios, int presupuesto) {
        int n = costos.length;
        int[][] tabla = new int[n + 1][presupuesto + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= presupuesto; j++) {
                if (costos[i - 1] <= j) {
                    tabla[i][j] = Math.max(tabla[i - 1][j], tabla[i - 1][j - costos[i - 1]] + beneficios[i - 1]);
                } else {
                    tabla[i][j] = tabla[i - 1][j];
                }
            }
        }

        return tabla[n][presupuesto];
    }

    public static void main(String[] args) {
        int[] costos = {10, 15, 20, 25};
        int[] beneficios = {100, 200, 150, 300};
        int presupuesto = 40;

        int rendimientoMaximo = seleccionProyectos(costos, beneficios, presupuesto);
        System.out.println("Rendimiento máximo del presupuesto: " + presupuesto + " es: " + rendimientoMaximo);
    }
}
