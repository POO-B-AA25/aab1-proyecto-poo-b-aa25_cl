package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

/**
 * Representa una factura:
 *  - idFactura (String)
 *  - fechaEmision (LocalDate)
 *  - cliente (objeto Cliente)
 *  - lineas (ArrayList<LineaFactura>)
 *  - subtotal, iva y total (double)
 *
 * Métodos para agregar líneas, calcular subtotal, IVA y total (restando deducciones).
 */
public class Factura {
    public String idFactura;
    public LocalDate fechaEmision;
    public Cliente cliente;
    public ArrayList<LineaFactura> lineas;
    public double subtotal;
    public double iva;
    public double total;

    /** Constructor: genera ID aleatorio y fecha actual, lista vacía de líneas. */
    public Factura() {
        this.idFactura    = UUID.randomUUID().toString().substring(0, 8);
        this.fechaEmision = LocalDate.now();
        this.lineas       = new ArrayList<>();
        this.subtotal     = 0.0;
        this.iva          = 0.0;
        this.total        = 0.0;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /** Agrega una línea a la factura */
    public void agregarLinea(LineaFactura linea) {
        lineas.add(linea);
    }

    /** Suma todos los subtotales de las líneas en this.subtotal */
    public void calcularSubtotal() {
        subtotal = 0.0;
        for (LineaFactura lf : lineas) {
            subtotal += lf.subtotalLinea;
        }
    }

    /** Calcula el IVA: tasaIva × subtotal */
    public void calcularIva(double tasaIva) {
        iva = subtotal * tasaIva;
    }

    /**
     * Calcula el total final:
     *  total = subtotal + iva − sumatoria(deducciones de cada línea)
     */
    public void calcularTotal(Deducible ded) {
        double deducciones = 0.0;
        for (LineaFactura lf : lineas) {
            deducciones += ded.calcularValorDeducible(lf.producto.categoria, lf.subtotalLinea);
        }
        total = subtotal + iva - deducciones;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Factura ID: ").append(idFactura).append("\n");
        sb.append("Fecha: ").append(fechaEmision).append("\n");
        sb.append("Cliente: ").append(cliente.toString()).append("\n");
        sb.append("---------------------------------------------------\n");
        sb.append(String.format("%-8s | %-25s | %-4s | %-8s | %-8s\n",
                "ProdID", "Nombre", "Cant", "PrecioU", "Subtotal"));
        sb.append("---------------------------------------------------\n");
        for (LineaFactura lf : lineas) {
            sb.append(lf.toString()).append("\n");
        }
        sb.append("---------------------------------------------------\n");
        sb.append(String.format("Subtotal: %.2f\n", subtotal));
        sb.append(String.format("IVA:      %.2f\n", iva));
        sb.append(String.format("Total:    %.2f\n", total));
        sb.append("---------------------------------------------------\n");
        return sb.toString();
    }
}
