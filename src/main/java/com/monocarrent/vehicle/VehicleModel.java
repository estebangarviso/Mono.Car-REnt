package com.monocarrent.vehicle;

public class VehicleModel {
    private String license_plate;
    private String brand;
    private String model;
    private int manufacture_year;
    private VehicleConditionStatus condition;

    public VehicleModel(String license_plate, String brand, String model, int manufacture_year, VehicleConditionStatus condition) {
        this.license_plate = license_plate;
        this.brand = brand;
        this.model = model;
        this.manufacture_year = manufacture_year;
        this.condition = condition;
    }

    public String getLicensePlate() {
        return license_plate;
    }

    public void setLicensePlate(String license_plate) {
        this.license_plate = license_plate;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getManufactureYear() {
        return manufacture_year;
    }

    public void setManufactureYear(int manufacture_year) {
        this.manufacture_year = manufacture_year;
    }

    public VehicleConditionStatus getCondition() {
        return condition;
    }

    public void setCondition(VehicleConditionStatus condition) {
        this.condition = condition;
    }

    @Override
    public String toString() {
        return "VehicleModel{" +
                "license_plate='" + license_plate + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", manufacture_year=" + manufacture_year +
                ", condition=" + condition.getCodeStatus() +
                '}';
    }
}