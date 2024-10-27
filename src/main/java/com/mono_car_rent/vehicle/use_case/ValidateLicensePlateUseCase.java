package com.mono_car_rent.vehicle.use_case;

public interface ValidateLicensePlateUseCase {
    /**
     * Validates the license plate of a vehicle.
     */
    public boolean isValidLicensePlate(String licensePlate);
}
