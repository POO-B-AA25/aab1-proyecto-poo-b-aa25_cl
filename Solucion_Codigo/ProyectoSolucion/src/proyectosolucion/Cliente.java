package proyectosolucion;

public class Cliente {
    private String id;
    private String nombre;
    private String correo;
    private int numeroTelefono;
    private String direccion;

    public Cliente(String id, String nombre, String correo, int numeroTelefono, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.numeroTelefono = numeroTelefono;
        this.direccion = direccion;
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setNumeroTelefono(int numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }
}
