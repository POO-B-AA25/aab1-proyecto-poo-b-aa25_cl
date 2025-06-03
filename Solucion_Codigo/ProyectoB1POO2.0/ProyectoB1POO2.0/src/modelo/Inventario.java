package modelo;

import java.util.ArrayList;

/**
 * Representa el inventario en memoria con un ArrayList de productos,
 * y métodos para agregar, buscar y mostrar el inventario.
 */
public class Inventario {
    public ArrayList<Producto> productos;

    public Inventario() {
        productos = new ArrayList<>();
    }

    /** Agrega un producto nuevo */
    public void agregarProducto(Producto p) {
        productos.add(p);
    }

    /** Busca un producto por ID; retorna null si no existe */
    public Producto buscarProducto(String id) {
        for (Producto p : productos) {
            if (p.idProducto.equals(id)) {
                return p;
            }
        }
        return null;
    }

    /** Muestra internamente una tabla con todos los productos del inventario */
    public void listarInventario() {
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("ID       | Nombre                    | Categoría    |  Precio  | Stock | Caduca");
        System.out.println("--------------------------------------------------------------------------");
        for (Producto p : productos) {
            System.out.println(p.toString());
        }
        System.out.println("--------------------------------------------------------------------------");
    }
}
