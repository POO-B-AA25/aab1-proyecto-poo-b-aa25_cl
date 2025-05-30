package modelo;

public class Cliente {
    private String id;
    private String nombre;
    private String correo;
    private int numeroTelefono;
    private String direccion;

    public Cliente() {}

    public Cliente(String id, String nombre, String correo,
                   int numeroTelefono, String direccion) {
        this.id             = id;
        this.nombre         = nombre;
        this.correo         = correo;
        this.numeroTelefono = numeroTelefono;
        this.direccion      = direccion;
    }

    public void setId(String id) {
        this.id = id;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public void setNumeroTelefono(int numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public String getCorreo() {
        return correo;
    }
    public int getNumeroTelefono() {
        return numeroTelefono;
    }
    public String getDireccion() {
        return direccion;
    }

    @Override
    public String toString() {
        return String.format(
            "Cliente[%s | %s | %s | Tel:%d | Dir:%s]",
            id, nombre, correo, numeroTelefono, direccion
        );
    }
}
