package controlador;

import modelo.*;
import java.time.LocalDate;
import java.util.*;
import java.util.Date;

public class SistemaController {
    private List<Cliente> clientes = new ArrayList<>();
    private Inventario inventario  = new Inventario();
    private EstadisticasVentas estadistica = new EstadisticasVentas();

    public void registrarCliente(String id, String nombre, String correo,
                                 int tel, String dir) {
        clientes.add(new Cliente(id, nombre, correo, tel, dir));
    }

    public boolean agregarProductoInventario(String nomProd, String categoria,
            double precio, double promo, int stock, LocalDate cad) {
        Producto p = new Producto(nomProd, stock, precio, categoria, cad, promo);
        inventario.agregarProducto(p);
        return true;
    }

    public Factura crearFactura(int clienteIndex, List<String> codigosProductos) {
        Factura f = new Factura();
        Cliente c = clientes.get(clienteIndex);
        f.agregarCliente(c);

        for (String cod : codigosProductos) {
            Producto p = inventario.buscar(cod);
            if (p != null) {
                f.agregarProducto(p);
            }
        }

        f.calcularSubtotal();
        f.calcularValorIva();
        f.calcularTotal();
        f.mostrarDeducible();
        f.verificarStock(inventario);

        // Actualizamos estadísticas usando getters:
        estadistica.setFecha(new Date());
        estadistica.setTotalVentas(f.getSubtotal());
        estadistica.setDeducible(f.getDeducible());
        estadistica.setConteoFacturas(estadistica.getConteoFacturas() + 1);

        return f;
    }

    public String getEstadistica() {
        return estadistica.toString();
    }

    public List<Cliente> getClientes() {
        return clientes;
    }
}
