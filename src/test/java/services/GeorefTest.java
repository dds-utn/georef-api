package services;

import domain.services.georef.ServicioGeoref;
import domain.services.georef.adapters.GeorefServiceAdapter;
import domain.services.georef.entities.ListadoDeMunicipios;
import domain.services.georef.entities.ListadoDeProvincias;
import domain.services.georef.entities.Municipio;
import domain.services.georef.entities.Provincia;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class GeorefTest {
    ServicioGeoref servicioGeoref;
    GeorefServiceAdapter adapterMock;

    @BeforeEach
    public void init() {
        this.adapterMock = mock(GeorefServiceAdapter.class);
        this.servicioGeoref = ServicioGeoref.instancia();
        this.servicioGeoref.setAdapter(this.adapterMock);
    }

    @Test
    public void servicioGeorefProveeListadoDeProvinciasTest() throws IOException {
        List<Provincia> provincias = this.provinciasMock();
        ListadoDeProvincias listadoDeProvinciasMock = mock(ListadoDeProvincias.class);

        when(listadoDeProvinciasMock.getProvincias()).thenReturn(provincias);
        when(this.adapterMock.listadoDeProvincias()).thenReturn(listadoDeProvinciasMock);

        Assertions.assertEquals(2, this.servicioGeoref.listadoDeProvincias().getProvincias().size());
    }

    private List<Provincia> provinciasMock() {
        List<Provincia> provincias = new ArrayList<>();
        provincias.add(new Provincia(1, "Buenos Aires"));
        provincias.add(new Provincia(2, "Santa Fe"));
        return provincias;
    }

    @Test
    public void servicioGeorefProveeMunicipiosDeBuenosAires() throws IOException {
        Provincia buenosAires = new Provincia(1, "Buenos Aires");
        List<Municipio> municipiosMock = this.municipiosMock();
        ListadoDeMunicipios listadoDeMunicipiosMock = mock(ListadoDeMunicipios.class);

        when(listadoDeMunicipiosMock.getMunicipios()).thenReturn(municipiosMock);
        when(this.adapterMock.listadoDeMunicipiosDeProvincia(buenosAires)).thenReturn(listadoDeMunicipiosMock);

        Assertions.assertEquals(2, this.servicioGeoref.listadoDeMunicipiosDeProvincia(buenosAires).getMunicipios().size());
    }

    private List<Municipio> municipiosMock() {
        List<Municipio> municipios = new ArrayList<>();
        municipios.add(new Municipio(1, "Ezeiza"));
        municipios.add(new Municipio(2, "San Martín"));
        return municipios;
    }
}
