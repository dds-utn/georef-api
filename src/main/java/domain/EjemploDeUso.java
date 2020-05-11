package domain;

import domain.model.ListadoDeMunicipios;
import domain.model.ListadoDeProvincias;
import domain.model.Municipio;
import domain.model.Provincia;
import domain.services.ServicioGeoref;

import java.io.IOException;
import java.util.Optional;
import java.util.Scanner;

public class EjemploDeUso {

    public static void main(String[] args) throws IOException {
        ServicioGeoref servicioGeoref = ServicioGeoref.instancia();
        System.out.println("Seleccione una de las siguientes provincias, ingresando su id:");
        ListadoDeProvincias listadoDeProvinciasArgentinas = servicioGeoref.listadoDeProvincias();
        for(Provincia unaProvincia:listadoDeProvinciasArgentinas.provincias){
            System.out.println(unaProvincia.id + ") " + unaProvincia.nombre);
        }
        Scanner entradaEscaner = new Scanner(System.in);
        String idProvinciaElegida = entradaEscaner.nextLine();
        Optional<Provincia> posibleProvincia = listadoDeProvinciasArgentinas.provinciaDeId(Integer.parseInt(idProvinciaElegida));
        if(posibleProvincia.isPresent()){
            Provincia provinciaSeleccionada = posibleProvincia.get();
            ListadoDeMunicipios municipiosDeLaProvincia = servicioGeoref.listadoDeMunicipiosDeProvincia(provinciaSeleccionada);
            System.out.println("Los municipios de la provincia "+ provinciaSeleccionada.nombre +" son:");
            for(Municipio unMunicipio: municipiosDeLaProvincia.municipios){
                System.out.println(unMunicipio.nombre);
            }
        }
        else{
            System.out.println("No existe la provincia seleccionada");
        }
    }
}