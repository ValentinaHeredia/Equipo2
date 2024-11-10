package clase10;

public class Actividad1 {

    static int N = 4; 
    static int[] tablero = new int[2]; 

    public static void main(String[] args) {
        colocarReinas(0);
    }

    public static void colocarReinas(int reina) {
        if (reina == 2) {
            imprimirTablero();
            return;
        }

        for (int i = 0; i < N; i++) {
            tablero[reina] = i;
            if (esValido(reina)) {
                colocarReinas(reina + 1);
            }
        }
    }

    public static boolean esValido(int reina) {
        for (int i = 0; i < reina; i++) {
            if (tablero[i] == tablero[reina] || Math.abs(tablero[i] - tablero[reina]) == Math.abs(i - reina)) {
                return false;
            }
        }
        return true;
    }

    public static void imprimirTablero() {
        char[][] tableroVisual = new char[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                tableroVisual[i][j] = '.';
            }
        }

        for (int i = 0; i < 2; i++) {
            tableroVisual[i][tablero[i]] = 'R';
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(tableroVisual[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
