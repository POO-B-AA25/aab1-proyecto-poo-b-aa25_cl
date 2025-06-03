package modelo;

/**
 * Representa una línea de detalle en la factura:
 *  - producto (objeto Producto)
 *  - cantidad (int)
 *  - precioUnitario (double)
 *  - subtotalLinea = cantidad × precioUnitario
 */
public class LineaFactura {
    public Producto producto;
    public int cantidad;
    public double precioUnitario;
    public double subtotalLinea;

    public LineaFactura() {}

    public LineaFactura(Producto producto, int cantidad, double precioUnitario) {
        this.producto       = producto;
        this.cantidad       = cantidad;
        this.precioUnitario = precioUnitario;
        calcularSubtotal();
    }

    /** Calcula subtotalLinea = cantidad × precioUnitario */
    public void calcularSubtotal() {
        this.subtotalLinea = this.cantidad * this.precioUnitario;
    }

    @Override
    public String toString() {
        return String.format(
            "%-8s | %-25s | %4d | %8.2f | %8.2f",
            producto.idProducto, producto.nombre,
            cantidad, precioUnitario, subtotalLinea
        );
    }
}
