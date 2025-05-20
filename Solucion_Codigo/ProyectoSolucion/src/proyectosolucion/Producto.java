package proyectosolucion;

import java.util.Date;

public class Producto {

    private String nomProducto;
    private int cantidadStock;
    private double precio;
    private String categoria;
    private Date fechaCaducidad;
    private double precioPromocional;

    public Producto(String nombre, int cantidad, double precio, String categoria) {
        this.nomProducto = nombre;
        this.cantidadStock = cantidad;
        this.precio = precio;
        this.categoria = categoria;
    }

    
    public String getNomProducto() {
        return nomProducto;
    }

    public void setNomProducto(String nomProducto) {
        this.nomProducto = nomProducto;
    }

    public int getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidad(int cantidad) {
        this.cantidadStock = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getCategoria() {
        return categoria;
    }

    public double getPrecioFinal() {
        return (precioPromocional > 0) ? precioPromocional : precio;
    }
}
