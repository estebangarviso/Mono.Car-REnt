package com.mono_car_rent.modules.vehicle;

import com.mono_car_rent.common.exception.general.BadRequestException;

import java.time.Year;

public class Vehicle {
    private String plate;
    private String brand;
    private String model;
    private int year;
    private VehicleConditionStatus condition = VehicleConditionStatus.DISPONIBLE;

    private Vehicle(String plate, String brand, String model, int year, VehicleConditionStatus condition) {
        this.plate = plate;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.condition = condition;
    }

    public static VehicleBuilder builder() {
        return new VehicleBuilder();
    }

    public String getPlate() {
        return this.plate;
    }

    public String getBrand() {
        return this.brand;
    }

    public String getModel() {
        return this.model;
    }

    public int getYear() {
        return this.year;
    }

    public VehicleConditionStatus getCondition() {
        return this.condition;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setCondition(VehicleConditionStatus condition) {
        this.condition = condition;
    }

    public VehicleBuilder toBuilder() {
        return new VehicleBuilder().plate(this.plate).brand(this.brand).model(this.model).year(this.year).condition(this.condition);
    }

    public static class VehicleBuilder {
        private String plate;
        private String brand;
        private String model;
        private int year;
        private VehicleConditionStatus condition;

        VehicleBuilder() {
        }

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

        public Vehicle build() {
            if (plate == null) {
                throw BadRequestException.isRequired("Plate");
            }
            if (brand == null) {
                throw BadRequestException.isRequired("Brand");
            }
            if (model == null) {
                throw BadRequestException.isRequired("Model");
            }
            if (year <= 0) {
                throw BadRequestException.isRequired("Year");
            }
            if (!isValidLicensePlate(plate)) {
                throw BadRequestException.invalidLicensePlate();
            }
            if (!isValidBrand(brand)) {
                throw BadRequestException.invalidBrand();
            }
            if (!isValidModel(model)) {
                throw BadRequestException.invalidModel();
            }
            if (!isValidManufactureYear(year)) {
                throw BadRequestException.invalidManufactureYear();
            }
            return new Vehicle(plate, brand, model, year, condition);
        }

        public VehicleBuilder plate(String plate) {
            this.plate = plate;
            return this;
        }

        public VehicleBuilder brand(String brand) {
            this.brand = brand;
            return this;
        }

        public VehicleBuilder model(String model) {
            this.model = model;
            return this;
        }

        public VehicleBuilder year(int year) {
            this.year = year;
            return this;
        }

        public VehicleBuilder condition(VehicleConditionStatus condition) {
            this.condition = condition;
            return this;
        }

        public String toString() {
            return "Vehicle.VehicleBuilder(plate=" + this.plate + ", brand=" + this.brand + ", model=" + this.model + ", year=" + this.year + ", condition=" + this.condition + ")";
        }
    }
}