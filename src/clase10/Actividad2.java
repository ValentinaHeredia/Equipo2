package clase10;

public class Actividad2 {

    static int N = 4; // Tamaño del tablero 4x4
    static int[] escritorios = new int[N]; // Almacena la posición de los escritorios
    static int[] sillas = new int[N]; // Almacena la posición de las sillas

    public static void main(String[] args) {
        colocarEscritorios(0);
    }

    // Función para colocar los escritorios en el tablero
    public static void colocarEscritorios(int filaEscritorio) {
        if (filaEscritorio == N) {
            colocarSillas(0);
            return;
        }

        for (int columna = 0; columna < N; columna++) {
            escritorios[filaEscritorio] = columna;
            if (esValido(escritorios, filaEscritorio)) {
                colocarEscritorios(filaEscritorio + 1);
            }
        }
    }

    // Función para colocar las sillas en el tablero
    public static void colocarSillas(int filaSilla) {
        if (filaSilla == N) {
            imprimirTablero();
            return;
        }

        for (int columna = 0; columna < N; columna++) {
            sillas[filaSilla] = columna;
            if (esValido(sillas, filaSilla) && noConflictoEscritoriosSillas(filaSilla)) {
                colocarSillas(filaSilla + 1);
            }
        }
    }

    // Verificar si no hay conflicto en filas o columnas
    public static boolean esValido(int[] posiciones, int fila) {
        for (int i = 0; i < fila; i++) {
            if (posiciones[i] == posiciones[fila]) { // Mismo columna
                return false;
            }
        }
        return true;
    }

    // Verificar que sillas no estén en la misma posición que los escritorios
    public static boolean noConflictoEscritoriosSillas(int fila) {
        for (int i = 0; i <= fila; i++) {
            if (escritorios[i] == sillas[i]) { // Mismo fila y columna
                return false;
            }
        }
        return true;
    }

    // Imprimir el tablero con las posiciones de escritorios y sillas
    public static void imprimirTablero() {
        char[][] tablero = new char[N][N];

        // Inicializar el tablero con espacios vacíos
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                tablero[i][j] = '.';
            }
        }

        // Colocar escritorios (E) en el tablero
        for (int i = 0; i < N; i++) {
            tablero[i][escritorios[i]] = 'E';
        }

        // Colocar sillas (S) en el tablero
        for (int i = 0; i < N; i++) {
            tablero[i][sillas[i]] = 'S';
        }

        // Imprimir el tablero
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
