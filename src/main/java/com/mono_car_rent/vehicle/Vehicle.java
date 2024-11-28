package com.mono_car_rent.vehicle;

import java.time.Year;

import com.mono_car_rent.common.Service;
import com.mono_car_rent.common.exception.general.BadRequestException;
import com.mono_car_rent.vehicle.use_case.*;

public class Vehicle extends Service implements ValidateLicensePlateUseCase, ValidateBrandUseCase, ValidateModelUseCase, ValidateManufactureYearUseCase {
    private String licensePlate;
    private String brand;
    private String model;
    private int manufactureYear;
    private VehicleConditionStatus condition = VehicleConditionStatus.DISPONIBLE;

    public Vehicle() {
        super(VehicleRepository.nextId());
    }

    //#region Getters and Setters
    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        if (!isValidLicensePlate(licensePlate)) {
            throw BadRequestException.invalidLicensePlate();
        }
        this.licensePlate = licensePlate;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        if (!isValidBrand(brand)) {
            throw BadRequestException.invalidBrand();
        }
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        if (!isValidModel(model)) {
            throw BadRequestException.invalidModel();
        }
        this.model = model;
    }

    public int getManufactureYear() {
        return manufactureYear;
    }

    public void setManufactureYear(int manufactureYear) {
        if (!isValidManufactureYear(manufactureYear)) {
            throw BadRequestException.invalidManufactureYear();
        }
        this.manufactureYear = manufactureYear;
    }

    public VehicleConditionStatus getCondition() {
        return condition;
    }

    public void setCondition(VehicleConditionStatus condition) {
        this.condition = condition;
    }
    //#endregion

    //#region Methods
    @Override
    public String toString() {
        return "Vehicle{" +
                "licensePlate='" + licensePlate + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", manufactureYear=" + manufactureYear +
                ", condition=" + condition.getCodeStatus() +
                '}';
    }
    //#endregion

    //#region Validation
    public boolean isValidLicensePlate(String licensePlate) {
        return licensePlate.matches("^[A-Z]{4}[0-9]{2}");
    }

    public boolean isValidBrand(String brand) {
        return brand.matches("^[A-Z0-9]+$");
    }

    public boolean isValidModel(String model) {
        return model.matches("^[A-Z0-9]+$");
    }

    public boolean isValidManufactureYear(int manufactureYear) {
        var currentYear = Year.now().getValue();
        return manufactureYear >= 2000 && manufactureYear <= currentYear;
    }
    //#endregion
}