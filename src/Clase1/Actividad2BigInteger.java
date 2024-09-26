package Clase1;

import java.math.BigInteger;

public class Actividad2BigInteger {
    private static BigInteger ColaFactorial(BigInteger n, BigInteger resultado) {
        if (n.equals(BigInteger.ZERO)) {
            return resultado;
        } else {
            return ColaFactorial(n.subtract(BigInteger.ONE), n.multiply(resultado));
        }
    }

    public static BigInteger factorial(BigInteger n) {
        return ColaFactorial(n, BigInteger.ONE);
    }

    public static void main(String[] args) {
        BigInteger numero = new BigInteger("50");
        BigInteger resultado = factorial(numero);
        System.out.println("El factorial de " + numero + " es " + resultado);
    }
}
