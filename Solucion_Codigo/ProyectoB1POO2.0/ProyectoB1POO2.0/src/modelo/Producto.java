package modelo;

import java.time.LocalDate;
import java.util.UUID;
import java.util.Random;

/**
 * Representa un producto en el inventario.
 * Contiene:
 *  - idProducto: ID único generado
 *  - nombre
 *  - categoria (String)
 *  - precioNormal
 *  - cantidadStock
 *  - fechaCaducidad (aleatoria al crear)
 */
public class Producto {
    public String idProducto;
    public String nombre;
    public String categoria;
    public double precioNormal;
    public int cantidadStock;
    public LocalDate fechaCaducidad;

    /** Constructor vacío */
    public Producto() {}

    /**
     * Constructor completo.
     * Asigna fecha de caducidad aleatoria entre 1 y 30 días desde hoy.
     */
    public Producto(String nombre, String categoria, double precioNormal, int cantidadStock) {
        this.idProducto    = UUID.randomUUID().toString().substring(0, 8);
        this.nombre        = nombre;
        this.categoria     = categoria;
        this.precioNormal  = precioNormal;
        this.cantidadStock = cantidadStock;
        // Fecha de caducidad aleatoria (1..30 días a partir de hoy)
        Random rnd = new Random();
        int dias   = rnd.nextInt(30) + 1;
        this.fechaCaducidad = LocalDate.now().plusDays(dias);
    }

    /**
     * Disminuye el stock. Retorna true si hubo stock suficiente; false si no.
     */
    public boolean disminuirStock(int cantidad) {
        if (cantidad <= this.cantidadStock) {
            this.cantidadStock -= cantidad;
            return true;
        }
        return false;
    }

    /** Aumenta el stock en la cantidad indicada */
    public void aumentarStock(int cantidad) {
        this.cantidadStock += cantidad;
    }

    @Override
    public String toString() {
        return String.format(
            "%-8s | %-25s | %-12s | %8.2f | %4d | %10s",
            idProducto, nombre, categoria, precioNormal, cantidadStock, fechaCaducidad.toString()
        );
    }
}
    