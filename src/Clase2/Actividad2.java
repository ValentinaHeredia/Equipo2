package Clase2;

public class Actividad2 {

    // Método para realizar la búsqueda binaria
    public static int busquedaBinaria(int[] array, int objetivo) {
        int izquierda = 0;
        int derecha = array.length - 1;

        while (izquierda <= derecha) {
            int medio = izquierda + (derecha - izquierda) / 2;

            // Verificar si el objetivo está en el medio
            if (array[medio] == objetivo) {
                return medio; // Retorna el índice del objetivo
            }

            // Si el objetivo es mayor, ignorar la mitad izquierda
            if (array[medio] < objetivo) {
                izquierda = medio + 1;
            } 
            // Si el objetivo es menor, ignorar la mitad derecha
            else {
                derecha = medio - 1;
            }
        }

        // Si no se encuentra el objetivo, retorna -1
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {1, 3, 5, 7, 9, 11, 13};
        int objetivo = 7;
        int resultado = busquedaBinaria(array, objetivo);

        if (resultado == -1) {
            System.out.println("Elemento no encontrado en el arreglo.");
        } else {
            System.out.println("Elemento encontrado en el índice: " + resultado);
        }
    }
}