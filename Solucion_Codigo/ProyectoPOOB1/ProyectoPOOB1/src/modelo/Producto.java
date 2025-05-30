package modelo;

import java.time.LocalDate;

public class Producto {
    private String nomProducto;
    private int cantidadStock;
    private double precio;
    private String categoria;
    private LocalDate fechaCaducidad;
    private double precioPromocional;
    private double precioFinal;

    public Producto() {}

    public Producto(String nomProducto, int cantidad, double precio,
                    String categoria, LocalDate fechaCaducidad, double promocional) {
        this.nomProducto       = nomProducto;
        this.cantidadStock     = cantidad;
        this.precio            = precio;
        this.categoria         = categoria;
        this.fechaCaducidad    = fechaCaducidad;
        this.precioPromocional = promocional;
        this.precioFinal       = calcularPrecioFinal();
    }

    public void setNomProducto(String nomProducto) {
        this.nomProducto = nomProducto;
    }
    public void setCantidad(int cantidad) {
        this.cantidadStock = cantidad;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getNomProducto() {
        return nomProducto;
    }
    public int getCantidad() {
        return cantidadStock;
    }
    public double getPrecio() {
        return precio;
    }
    public String getCategoria() {
        return categoria;
    }

    /** ¿Tiene precio promocional válido? */
    public boolean esPromocional() {
        return precioPromocional > 0 && precioPromocional < precio;
    }

    /** Calcula y devuelve el precio final */
    public double calcularPrecioFinal() {
        if (esPromocional()) {
            precioFinal = precioPromocional;
        } else {
            precioFinal = precio;
        }
        return precioFinal;
    }

    public double getPrecioFinal() {
        return precioFinal;
    }
    

    @Override
    public String toString() {
        return String.format(
            "Producto[%s | Cat:%s | Stock:%d | Precio:%.2f | Promo:%.2f | Final:%.2f | Caduca:%s]",
            nomProducto, categoria, cantidadStock, precio, precioPromocional, precioFinal, fechaCaducidad
        );
    }
}
