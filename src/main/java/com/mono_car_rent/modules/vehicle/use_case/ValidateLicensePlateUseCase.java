package com.mono_car_rent.modules.vehicle.use_case;

public interface ValidateLicensePlateUseCase {
    /**
     * Validates the license plate of a vehicle.
     */
    public boolean isValidLicensePlate(String licensePlate);
}
