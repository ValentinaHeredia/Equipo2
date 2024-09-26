package clase4;
import java.util.*;

public class Ejercicio2 {
    public static class comprobante{
        String nombre;
        int valor;
        public comprobante(String nombre, int valor) {
            this.nombre = nombre;
            this.valor = valor;
        }
    }
    
    public static comprobante [] comprarMonedaExtranjera (comprobante [] Comprobantes, int monto){
        Arrays.sort(Comprobantes, (c1, c2) -> Integer.compare(c2.valor, c1.valor));
        comprobante [] Cambio = new comprobante[50];
        int j = 0;

        for(int i = 0; i < Comprobantes.length ; i++ ){
            while (monto >= Comprobantes[i].valor){
                monto-= Comprobantes[i].valor;
                Cambio[j] = Comprobantes[i];
                j++;
            }
        }
        return Cambio;
    }

    public static void main(String[] args) {
        comprobante[] comprobantes = {new comprobante("cheque", 500), new comprobante("monedas", 100), new comprobante("bono", 50), new comprobante("billete", 10)};
        int monto = 2760;

        comprobante[] resultado = comprarMonedaExtranjera(comprobantes, monto);
        if (resultado.length > 0) {
            System.out.println("Comprobantes utilizados:");
            for (int i = 0; i< resultado.length;i++) {
                System.out.println("Comprobante: " + resultado[i].nombre + ", Valor: " + resultado[i].valor);
            }
        } else {
            System.out.println("No es posible dar el cambio exacto.");
        }
    }
}
