package com.mono_car_rent.modules.rental.dto;

import java.util.Date;

public record RentalUpdateDTO(
        /**
         * Rental's start date.
         */
        Date startDate,
        /**
         * Rental's rental days.
         */
        int rentalDays
) {}
