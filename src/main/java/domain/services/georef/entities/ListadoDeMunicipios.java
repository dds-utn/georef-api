package domain.services.georef.entities;

import java.util.List;

public class ListadoDeMunicipios {
    public int cantidad;
    public int total;
    public int inicio;
    public Parametro parametros;
    public List<Municipio> municipios;

    private class Parametro {
        public List<String> campos;
        public int max;
        public List<String> provincia;
    }
}