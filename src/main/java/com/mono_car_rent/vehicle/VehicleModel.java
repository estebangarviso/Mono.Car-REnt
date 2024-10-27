package com.mono_car_rent.vehicle;

import com.mono_car_rent.common.Model;



public class VehicleModel extends Model{
    private String licensePlate;
    private String brand;
    private String model;
    private int manufactureYear;
    private VehicleConditionStatus condition;

    public VehicleModel(String licensePlate, String brand, String model, int manufactureYear, VehicleConditionStatus condition) {
        super(VehicleRepository.nextId());
        this.licensePlate = licensePlate;
        this.brand = brand;
        this.model = model;
        this.manufactureYear = manufactureYear;
        this.condition = condition;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
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
        return manufactureYear;
    }

    public void setManufactureYear(int manufactureYear) {
        this.manufactureYear = manufactureYear;
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
                "licensePlate='" + licensePlate + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", manufactureYear=" + manufactureYear +
                ", condition=" + condition.getCodeStatus() +
                '}';
    }
}