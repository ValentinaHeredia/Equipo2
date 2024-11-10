package clase13;

public class Actividad2 {

    public static boolean esValido(int[][] tablero, int fila, int columna, int num) {

        for (int i = 0; i < 6; i++) {
            if (tablero[fila][i] == num) {
                return false;
            }
        }
    
        for (int i = 0; i < 6; i++) {
            if (tablero[i][columna] == num) {
                return false;
            }
        }

        int subcuadranteFila = (fila / 2) * 2;  
        int subcuadranteCol = (columna / 3) * 3; 
        for (int i = 0; i < 2; i++) { 
            for (int j = 0; j < 3; j++) {  
                if (tablero[subcuadranteFila + i][subcuadranteCol + j] == num) {
                    return false;
                }
            }
        }
    
        return true;
    }
    

    public static boolean resolverSudoku(int[][] tablero) {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (tablero[i][j] == 0) { 
                    for (int num = 1; num <= 6; num++) { 
                        if (esValido(tablero, i, j, num)) {
                            tablero[i][j] = num;
                            if (resolverSudoku(tablero)) {
                                return true;
                            }
                            tablero[i][j] = 0; 
                        }
                    }
                    return false;
                }
            }
        }
        return true; 
    }

    public static void imprimirTablero(int[][] tablero) {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] tablero = {
            {5, 3, 0, 0, 0, 6},
            {6, 0, 0, 1, 0, 3},
            {0, 0, 1, 0, 0, 0},
            {0, 1, 0, 6, 0, 0},
            {0, 6, 0, 0, 0, 4},
            {4, 0, 0, 0, 1, 0}
        };

        if (resolverSudoku(tablero)) {
            imprimirTablero(tablero);
        } else {
            System.out.println("No se puede resolver el Sudoku.");
        }
    }
}
