package com.monocarrent;

import com.monocarrent.arriendo.Arriendo;
import com.monocarrent.vehiculo.Vehiculo;

public class App
{
    public static void main( String[] args )
    {
        Arriendo arriendo = new Arriendo();
        arriendo.arrendar();
        // private String n_patente;
        // private String marca;
        // private String modelo;
        // private int a_fabricacion;
        // private String condicion;
        Vehiculo vehiculo = new Vehiculo('JCZL21','PEUGEOT','301',2017,'D');
        vehiculo.cambiarCondicion(nuevaCondicion);
    }
}
