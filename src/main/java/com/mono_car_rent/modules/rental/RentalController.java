package com.mono_car_rent.modules.rental;

import com.mono_car_rent.modules.rental.dto.RentalSaveDTO;
import com.mono_car_rent.modules.rental.dto.RentalUpdateDTO;
import com.mono_car_rent.modules.rental.rental.Rental;
import com.mono_car_rent.modules.rental.rental.RentalService;

public class RentalController {
    private final RentalService rentalService = new RentalService();

    public Rental create(RentalSaveDTO rentalSaveDTO) throws Throwable {
        return rentalService.create(rentalSaveDTO);
    }

    public Rental get(int id) throws Throwable {
        return rentalService.get(id);
    }

    public Rental update(int id, RentalUpdateDTO rentalUpdateDTO) throws Throwable {
        return rentalService.update(id, rentalUpdateDTO);
    }
}
