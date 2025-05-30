package modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa una factura con cliente(s) y producto(s), 
 * cálculo de subtotal, IVA, total y deducible.
 */
public class Factura {
    private List<Cliente> clientes   = new ArrayList<>();
    private List<Producto> productos = new ArrayList<>();
    private double subtotal;
    private double valorIva;
    private double total;
    private Deducible deducible;

    public Factura() {}

    public Factura(List<Cliente> clientes, List<Producto> productos) {
        this.clientes  = clientes;
        this.productos = productos;
    }

    public void agregarCliente(Cliente c) {
        clientes.add(c);
    }

    public void agregarProducto(Producto p) {
        productos.add(p);
    }

    /** Calcula la sumatoria de los precios finales de los productos */
    public void calcularSubtotal() {
        subtotal = productos.stream()
            .mapToDouble(Producto::getPrecioFinal)
            .sum();
    }

    /** Calcula IVA al 12% sobre el subtotal */
    public void calcularValorIva() {
        valorIva = subtotal * 0.12;
    }

    /** Calcula el total (subtotal + IVA) */
    public void calcularTotal() {
        total = subtotal + valorIva;
    }

    /** Inicializa el deducible al 5% sobre los productos */
    public void mostrarDeducible() {
        deducible = new Deducible(5.0, productos);
    }

    /** Verifica stock en el inventario (no modifica nada por ahora) */
    public void verificarStock(Inventario inv) {
        for (Producto p : productos) {
            inv.buscar(p.getNomProducto());
        }
    }

    /* ==== GETTERS ADICIONALES PARA USO EN EL CONTROLADOR ==== */

    /** Devuelve el subtotal ya calculado */
    public double getSubtotal() {
        return subtotal;
    }

    /** Devuelve el valor de IVA ya calculado */
    public double getValorIva() {
        return valorIva;
    }

    /** Devuelve el total ya calculado */
    public double getTotal() {
        return total;
    }

    /** Devuelve el objeto Deducible calculado */
    public Deducible getDeducible() {
        return deducible;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Factura:\n");
        clientes.forEach(c -> sb.append("  ").append(c).append("\n"));
        productos.forEach(p -> sb.append("  ").append(p).append("\n"));
        sb.append(String.format("Subtotal: %.2f\n", subtotal));
        sb.append(String.format("IVA: %.2f\n", valorIva));
        sb.append(String.format("Total: %.2f\n", total));
        if (deducible != null) {
            sb.append("Deducible: ").append(deducible).append("\n");
        }
        return sb.toString();
    }
}
