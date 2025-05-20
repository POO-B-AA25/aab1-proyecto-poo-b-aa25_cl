package proyectosolucion;

import java.util.ArrayList;

public class Inventario {
    private ArrayList<Producto> productos;

    public Inventario() {
        this.productos = new ArrayList<>();
    }

    public Inventario(ArrayList<Producto> productos) {
        this.productos = productos;
    }
    
    // Métodos para manejar el inventario
    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }
}
