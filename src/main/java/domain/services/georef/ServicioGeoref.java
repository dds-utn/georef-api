package domain.services.georef;

import domain.services.georef.adapters.GeorefServiceAdapter;
import domain.services.georef.entities.ListadoDeMunicipios;
import domain.services.georef.entities.ListadoDeProvincias;
import domain.services.georef.entities.Provincia;

import java.io.IOException;

public class ServicioGeoref {
    private static ServicioGeoref instancia = null;
    private GeorefServiceAdapter adapter;

    private ServicioGeoref() {

    }

    public void setAdapter(GeorefServiceAdapter adapter) {
        this.adapter = adapter;
    }

    public GeorefServiceAdapter getAdapter() {
        return adapter;
    }

    public static ServicioGeoref instancia(){
        if(instancia== null){
            instancia = new ServicioGeoref();
        }
        return instancia;
    }

    public ListadoDeProvincias listadoDeProvincias() throws IOException {
       return this.adapter.listadoDeProvincias();
    }

    public ListadoDeMunicipios listadoDeMunicipiosDeProvincia(Provincia provincia) throws IOException {
        return this.adapter.listadoDeMunicipiosDeProvincia(provincia);
    }
}