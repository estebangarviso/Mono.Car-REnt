package com.mono_car_rent.modules.rental.dto;

import java.util.Date;

public record RentalSaveDTO(
    /**
     * Rental's customer identity card.
     */
    String customerIdentityCard,
    /**
     * Rental's vehicle plate.
     */
    String vehiclePlate,
    /**
     * Rental's start date.
     */
    Date startDate,
    /**
     * Rental's rental days.
     */
    int rentalDays
) {
}
