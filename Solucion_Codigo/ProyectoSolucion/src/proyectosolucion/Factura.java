package proyectosolucion;
import java.util.ArrayList;

public class Factura {
    private ArrayList<Cliente> clientes;
    private ArrayList<Producto> productos;
    private Inventario inventario;
    private double total;
    private double subtotal;
    private int contadorFacturas;

    public Factura(ArrayList<Cliente> clientes, ArrayList<Producto> productos) {
        this.clientes = clientes;
        this.productos = productos;
    }

    

    public double calcularTotal() {
        total = 0.0;
        for (Producto p : productos) {
            total += p.getPrecioFinal();
        }
        return total;
    }
}
