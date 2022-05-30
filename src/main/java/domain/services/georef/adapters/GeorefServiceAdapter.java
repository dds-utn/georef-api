package domain.services.georef.adapters;

import domain.services.georef.entities.ListadoDeMunicipios;
import domain.services.georef.entities.ListadoDeProvincias;
import domain.services.georef.entities.Provincia;

import java.io.IOException;

public interface GeorefServiceAdapter {
    public ListadoDeProvincias listadoDeProvincias() throws IOException;
    public ListadoDeMunicipios listadoDeMunicipiosDeProvincia(Provincia provincia) throws IOException;
}
