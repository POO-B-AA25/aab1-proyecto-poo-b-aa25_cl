package modelo;

import java.util.List;

public class Gerente {
    private String nombre;
    private String identificacion;

    public Gerente() {}
    public Gerente(String nombre, String identificacion) {
        this.nombre         = nombre;
        this.identificacion = identificacion;
    }

    /** Podrías descontar stock aquí */
    public void actualizarStock(Inventario inv, List<Producto> ventas) {
        for (Producto p : ventas) {
            // Producto enInv = inv.buscar(p.getNomProducto());
            // if (enInv != null) enInv.descontarStock(1);
        }
    }

    @Override
    public String toString() {
        return String.format("Gerente[%s | ID:%s]", nombre, identificacion);
    }
}
