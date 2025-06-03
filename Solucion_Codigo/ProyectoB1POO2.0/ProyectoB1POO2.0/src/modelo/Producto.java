package modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;
import java.util.Random;

public class Producto implements Serializable{
    public String idProducto;
    public String nombre;
    public String categoria;
    public double precioNormal;
    public int cantidadStock;
    public LocalDate fechaCaducidad;


    public Producto() {}


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

    public boolean disminuirStock(int cantidad) {
        if (cantidad <= this.cantidadStock) {
            this.cantidadStock -= cantidad;
            return true;
        }
        return false;
    }

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
    