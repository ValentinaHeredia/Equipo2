package Clase1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ClienteMaps {
    int idCliente;
    String nombreCliente;

    public ClienteMaps(int idCliente, String nombreCliente) {
        this.idCliente = idCliente;
        this.nombreCliente = nombreCliente;
    }
}

class FacturaMaps {
    int idFactura;
    int idCliente;
    double importe;

    public FacturaMaps(int idFactura, int idCliente, double importe) {
        this.idFactura = idFactura;
        this.idCliente = idCliente;
        this.importe = importe;
    }
}

public class Actividad1BconMaps {
    public static void main(String[] args) {
        // Lista de clientes
        List<ClienteMaps> clientes = new ArrayList<>();
        clientes.add(new ClienteMaps(1, "Cliente A"));
        clientes.add(new ClienteMaps(2, "Cliente B"));
        clientes.add(new ClienteMaps(3, "Cliente C"));

        // Lista de facturas
        List<FacturaMaps> facturas = new ArrayList<>();
        facturas.add(new FacturaMaps(101, 1, 100.0));
        facturas.add(new FacturaMaps(102, 2, 200.0));
        facturas.add(new FacturaMaps(103, 1, 150.0));
        facturas.add(new FacturaMaps(104, 3, 300.0));
        facturas.add(new FacturaMaps(105, 2, 50.0));

        // Calcula la suma de importes por cliente usando Maps
        Map<Integer, Double> sumaImportesPorCliente = new HashMap<>();

        for (FacturaMaps factura : facturas) {
            sumaImportesPorCliente.put(factura.idCliente,
                sumaImportesPorCliente.getOrDefault(factura.idCliente, 0.0) + factura.importe);
        }

        for (ClienteMaps cliente : clientes) {
            double sumaImportes = sumaImportesPorCliente.getOrDefault(cliente.idCliente, 0.0);
            System.out.println("Cliente: " + cliente.nombreCliente + ", Total de importes: " + sumaImportes);
        }
    }
}


//Complejidad O(m+n)