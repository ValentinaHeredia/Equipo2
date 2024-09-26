package clase4;
import java.util.*;


public class Ejecicio1 {
    public static boolean MonedasDisponibles (int [] monedas, int monto){
        Arrays.sort(monedas);
        List<Integer> cambio = new ArrayList<>();
        for(int i = monedas.length-1 ; i>=0 ; i--){
            while ( monto >= monedas[i]){
                monto -= monedas[i];
                cambio.add(i);
            }
        }
        if (monto==0) {
            return true;
        }
        else{
            return false;
        }
    }
    public static void main(String[] args) {
        int [] monedas = {50, 25, 10, 5};
        int monto = 585;
        MonedasDisponibles(monedas, monto);
        System.out.println("Hay un cambio exacto?:" + MonedasDisponibles(monedas, monto));
    }
}

