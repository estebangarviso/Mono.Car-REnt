package com.mono_car_rent.modules.rental_return.use_case;

import java.util.Date;

public interface ValidateReturnDateUseCase {

    /**
     * Validates the return date of a rental.
     */
    public boolean isValidReturnDate(Date returnDate);
}
