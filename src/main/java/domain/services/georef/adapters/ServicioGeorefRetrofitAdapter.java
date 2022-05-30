package domain.services.georef.adapters;

import domain.services.georef.ServicioGeoref;
import domain.services.georef.entities.ListadoDeMunicipios;
import domain.services.georef.entities.ListadoDeProvincias;
import domain.services.georef.entities.Provincia;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

public class ServicioGeorefRetrofitAdapter implements GeorefServiceAdapter {
    private static ServicioGeoref instancia = null;
    private static int maximaCantidadRegistrosDefault = 200;
    private static final String urlApi = "https://apis.datos.gob.ar/georef/api/";
    private Retrofit retrofit;

    public ServicioGeorefRetrofitAdapter() {
        this.retrofit = new Retrofit.Builder()
                .baseUrl(urlApi)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public ListadoDeProvincias listadoDeProvincias() throws IOException {
        GeorefService georefService = this.retrofit.create(GeorefService.class);
        Call<ListadoDeProvincias> requestProvinciasArgentinas = georefService.provincias();
        Response<ListadoDeProvincias> responseProvinciasArgentinas = requestProvinciasArgentinas.execute();
        System.out.println(responseProvinciasArgentinas.code());
        return responseProvinciasArgentinas.body();
    }

    public ListadoDeMunicipios listadoDeMunicipiosDeProvincia(Provincia provincia) throws IOException {
        GeorefService georefService = this.retrofit.create(GeorefService.class);
        Call<ListadoDeMunicipios> requestListadoDeMunicipios = georefService.municipios(provincia.id, "id, nombre", maximaCantidadRegistrosDefault);
        Response<ListadoDeMunicipios> responseListadoDeMunicipios = requestListadoDeMunicipios.execute();
        return responseListadoDeMunicipios.body();
    }
}
