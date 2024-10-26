package com.monocarrent.vehicle;

import com.monocarrent.common.enums.ConditionStatus;

public class Vehicle {
    private String license_plate;
    private String brand;
    private String model;
    private int manufacture_year;
    private ConditionStatus condition;

    public Vehicle(String license_plate, String brand, String model, int manufacture_year, ConditionStatus condition) {
        this.license_plate = license_plate;
        this.brand = brand;
        this.model = model;
        this.manufacture_year = manufacture_year;
        this.condition = condition;
    }

    public void changeCondition(ConditionStatus nuevaCondicion) {
        this.condition = nuevaCondicion;
    }

    public void validateLicensePlate() {
        // Validation logic for patente
    }
}