package modelo;

import java.util.ArrayList;
import java.util.List;

public class Inventario {
    private List<Producto> productos = new ArrayList<>();

    public Inventario() {}
    public Inventario(List<Producto> productos) {
        this.productos = productos;
    }

    public void agregarProducto(Producto p) {
        productos.add(p);
    }

    public List<Producto> getProductos() {
        return productos;
    }

    /** Busca por nombre (ignora mayúsculas) */
    public Producto buscar(String nomProducto) {
        for (Producto p : productos) {
            if (p.getNomProducto().equalsIgnoreCase(nomProducto)) {
                return p;
            }
        }
        return null;
    }
}
