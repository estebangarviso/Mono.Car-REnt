package com.mono_car_rent.rental.use_case;

public interface ValidateRentalDaysUseCase {
    /**
     * Validates the rental days of a rental.
     */
    public boolean isValidRentalDays(int rentalDays);
}
