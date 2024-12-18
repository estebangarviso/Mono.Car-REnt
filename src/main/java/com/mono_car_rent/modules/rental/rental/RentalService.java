package com.mono_car_rent.modules.rental.rental;

import com.mono_car_rent.common.RepositoryResponse;
import com.mono_car_rent.modules.rental.dto.RentalSaveDTO;
import com.mono_car_rent.modules.rental.dto.RentalUpdateDTO;
import com.mono_car_rent.modules.rental.use_case.RentalCRUDUseCase;

public class RentalService implements RentalCRUDUseCase {
    private final RentalRepository rentalRepository = RentalRepository.getInstance();

    @Override
    public Rental create(RentalSaveDTO rentalSaveDTO) throws Throwable {
        RepositoryResponse<Rental> saved = rentalRepository.save(rentalSaveDTO);

        if (!saved.isSuccess()) {
            throw saved.getError();
        }

        return saved.getValue();
    }

    @Override
    public Rental get(int id) throws Throwable {
        RepositoryResponse<Rental> found = rentalRepository.findById(id);

        if (!found.isSuccess()) {
            throw found.getError();
        }

        return found.getValue();
    }

    @Override
    public Rental update(int id, RentalUpdateDTO rentalUpdateDTO) throws Throwable {
        RepositoryResponse<Rental> updated = rentalRepository.update(id, rentalUpdateDTO);

        if (!updated.isSuccess()) {
            throw updated.getError();
        }

        return updated.getValue();
    }
}
