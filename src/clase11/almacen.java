package clase11;

public class almacen {
    private int id;  
    private String nombre; 

    // Constructor de la clase
    public almacen(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    // Métodos getter y setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Almacen{id=" + id + ", nombre='" + nombre + "'}";
    }
}
