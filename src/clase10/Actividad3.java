package clase10;

public class Actividad3 {

    static final int N = 4; // Tamaño del tablero
    static char[][] tablero = new char[N][N];

    public static void main(String[] args) {
        // Inicializar el tablero vacío
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                tablero[i][j] = '.'; // Espacios vacíos
            }
        }
        
        // Iniciar backtracking
        colocarComputadoras(0);
    }

    // Función de backtracking para colocar computadoras en el tablero
    static void colocarComputadoras(int fila) {
        if (fila == N) {
            colocarImpresoras(0); // Proceder a colocar impresoras
            return;
        }
        
        for (int col = 0; col < N; col++) {
            if (esValido(fila, col, 'C')) {
                tablero[fila][col] = 'C'; // Colocar una computadora
                colocarComputadoras(fila + 1); // Colocar la siguiente computadora
                tablero[fila][col] = '.'; // Retroceso
            }
        }
    }

    // Función de backtracking para colocar impresoras en el tablero
    static void colocarImpresoras(int fila) {
        if (fila == N) {
            imprimirTablero(); // Imprimir la configuración válida encontrada
            return;
        }
        
        for (int col = 0; col < N; col++) {
            if (esValido(fila, col, 'P')) {
                tablero[fila][col] = 'P'; // Colocar una impresora
                colocarImpresoras(fila + 1); // Colocar la siguiente impresora
                tablero[fila][col] = '.'; // Retroceso
            }
        }
    }

    // Verifica si es válido colocar una computadora o impresora en una posición dada
    static boolean esValido(int fila, int col, char tipo) {
        // Verificar fila y columna
        for (int i = 0; i < N; i++) {
            if (tablero[fila][i] == tipo || tablero[i][col] == tipo) {
                return false;
            }
        }
        return true;
    }

    // Imprime el tablero
    static void imprimirTablero() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
