package Clase1;

public class Actividad2Long {
    private static long ColaFactorial(long n, long resultado) {
        if (n == 0) {
            return resultado;
        } else {
            return ColaFactorial(n - 1, n * resultado);
        }
    }

    public static long Factorial(long n) {
        return ColaFactorial(n, 1);
    }

    public static void main(String[] args) {
        long numero = 5;
        long resultado = Factorial(numero);
        System.out.println("El factorial de " + numero + " es " + resultado);
    }
}
