package com.mono_car_rent.modules.rental.use_case;

import com.mono_car_rent.modules.rental.rental.Rental;
import com.mono_car_rent.modules.rental.dto.RentalSaveDTO;
import com.mono_car_rent.modules.rental.dto.RentalUpdateDTO;

public interface RentalCRUDUseCase {
    /**
     * Create a new rental.
     *
     * @param rentalSaveDTO the rental to create
     * @return the created rental
     * @throws Throwable if an error occurs
     */
    Rental create(RentalSaveDTO rentalSaveDTO) throws Throwable;

    /**
     * Get a rental by id.
     *
     * @param id the rental id
     * @return the rental found
     * @throws Throwable if an error occurs
     */
    Rental get(int id) throws Throwable;

    /**
     * Update a rental.
     *
     * @param id the rental id
     * @param rentalUpdateDTO the rental to update
     * @return the updated rental
     * @throws Throwable if an error occurs
     */
    Rental update(int id, RentalUpdateDTO rentalUpdateDTO) throws Throwable;
}
