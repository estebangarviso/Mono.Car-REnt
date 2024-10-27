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
        if (!validateLicensePlate(licensePlate)) {
            throw BadRequestException.invalidLicensePlate();
        }
        this.licensePlate = licensePlate;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        if (!validateBrand(brand)) {
            throw BadRequestException.invalidBrand();
        }
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        if (!validateModel(model)) {
            throw BadRequestException.invalidModel();
        }
        this.model = model;
    }

    public int getManufactureYear() {
        return manufactureYear;
    }

    public void setManufactureYear(int manufactureYear) {
        if (!validateManufactureYear(manufactureYear)) {
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
    /**
     * Validates the license plate of a vehicle.
     */
    public boolean validateLicensePlate(String licensePlate) {
        return licensePlate.matches("^[A-Z]{4}[0-9]{2}-[0-9]$");
    }

    /**
     * Validates the brand of a vehicle.
     */
    public boolean validateBrand(String brand) {
        return brand.matches("^[A-Z]+$");
    }

    /**
     * Validates the model of a vehicle.
     */
    public boolean validateModel(String model) {
        return model.matches("^[A-Z]+$");
    }

    /**
     * Validates the manufacture year of a vehicle.
     */
    public boolean validateManufactureYear(int manufactureYear) {
        var currentYear = Year.now().getValue();
        return manufactureYear >= 2000 && manufactureYear <= currentYear;
    }
    //#endregion
}