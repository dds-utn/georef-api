package domain.services;

import domain.model.ListadoDeMunicipios;
import domain.model.ListadoDeProvincias;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GeorefService {
    @GET("/georef/api/provincias")
    Call<ListadoDeProvincias> provincias();

    @GET("/georef/api/provincias")
    Call<ListadoDeProvincias> provincias(@Query("campos") String campos);

    @GET("/georef/api/municipios")
    Call<ListadoDeMunicipios> municipios(@Query("provincia") int idProvincia);

    @GET("/georef/api/municipios")
    Call<ListadoDeMunicipios> municipios(@Query("provincia") int idProvincia, @Query("campos") String campos);

    @GET("/georef/api/municipios")
    Call<ListadoDeMunicipios> municipios(@Query("provincia") int idProvincia, @Query("campos") String campos, @Query("max") int max);
}