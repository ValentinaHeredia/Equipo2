package Clase1;

import java.util.ArrayList;
import java.util.List;

class Cliente {
    int idCliente;
    String nombreCliente;

    public Cliente(int idCliente, String nombreCliente) {
        this.idCliente = idCliente;
        this.nombreCliente = nombreCliente;
    }
}

class Factura {
    int idFactura;
    int idCliente;
    double importe;

    public Factura(int idFactura, int idCliente, double importe) {
        this.idFactura = idFactura;
        this.idCliente = idCliente;
        this.importe = importe;
    }
}

public class Actividad1BsinMaps {
    public static void main(String[] args) {
        // Lista de clientes
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente(1, "Cliente A"));
        clientes.add(new Cliente(2, "Cliente B"));
        clientes.add(new Cliente(3, "Cliente C"));

        // Lista de facturas
        List<Factura> facturas = new ArrayList<>();
        facturas.add(new Factura(101, 1, 100.0));
        facturas.add(new Factura(102, 2, 200.0));
        facturas.add(new Factura(103, 1, 150.0));
        facturas.add(new Factura(104, 3, 300.0));
        facturas.add(new Factura(105, 2, 50.0));

        // Calcula la suma de importes por cliente sin usar Maps
        for (Cliente cliente : clientes) {
            double sumaImportes = 0.0;
            for (Factura factura : facturas) {
                if (factura.idCliente == cliente.idCliente) {
                    sumaImportes += factura.importe;
                }
            }
            System.out.println("Cliente: " + cliente.nombreCliente + ", Total de importes: " + sumaImportes);
        }
    }
}

//Complejidad asintonica O(n*m)