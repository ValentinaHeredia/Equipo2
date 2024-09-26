package Clase1;

public class Actividad3 {
    public static int sumaNumeros(int n) {
        if (n == 0) {
            return 0;
        } else {
            return n + sumaNumeros(n - 1);
        }
    }

    public static void main(String[] args) {
        int numero = 5;
        int resultado = sumaNumeros(numero);
        System.out.println("La suma de los primeros " + numero + " números enteros es: " + resultado);
    }
}


//Analisis de recurrencia (simplificado) T(n)=O(n)+T(0)=O(n)+O(1)=O(n)