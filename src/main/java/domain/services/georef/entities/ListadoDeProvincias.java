package domain.services.georef.entities;

import java.util.List;
import java.util.Optional;

public class ListadoDeProvincias {
    public int cantidad;
    public int total;
    public int inicio;
    public Parametro parametros;
    public List<Provincia> provincias;

    public Optional<Provincia> provinciaDeId(int id){
        return this.provincias.stream()
                .filter(p -> p.id == id)
                .findFirst();
    }

    private class Parametro {
        public List<String> campos;
    }
}