package modelo;

/**
 * Representa un cliente para la factura.
 * Campos:
 *  - idCliente
 *  - nombre
 *  - correo
 *  - telefono
 *  - direccion
 */
public class Cliente {
    public String idCliente;
    public String nombre;
    public String correo;
    public String telefono;
    public String direccion;

    public Cliente() {}

    public Cliente(String idCliente, String nombre, String correo, String telefono, String direccion) {
        this.idCliente = idCliente;
        this.nombre    = nombre;
        this.correo    = correo;
        this.telefono  = telefono;
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return String.format("%s | %s | %s | %s | %s",
            idCliente, nombre, correo, telefono, direccion);
    }
}
