package domain.services.georef.entities;

public class Municipio {
    public int id;
    public String nombre;

    public Municipio(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Municipio() {

    }

    public String getNombre() {
        return nombre;
    }
}
