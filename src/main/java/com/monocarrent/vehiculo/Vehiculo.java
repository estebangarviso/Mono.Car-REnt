package com.monocarrent.vehiculo;

public class Vehiculo {
    private String n_patente;
    private String marca;
    private String modelo;
    private int a_fabricacion;
    private String condicion;

    public Vehiculo(String n_patente, String marca, String modelo, int a_fabricacion, String condicion) {
        this.n_patente = n_patente;
        this.marca = marca;
        this.modelo = modelo;
        this.a_fabricacion = a_fabricacion;
        this.condicion = condicion;
    }

    public void cambiarCondicion(String nuevaCondicion) {
        this.condicion = nuevaCondicion;
    }

    public void validarPatente() {
        // Validation logic for patente
    }

    // Getters and Setters
}