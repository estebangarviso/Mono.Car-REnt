package com.mono_car_rent.modules.rental.rental;

import com.google.gson.reflect.TypeToken;
import com.mono_car_rent.common.AbstractRepository;
import com.mono_car_rent.common.RepositoryResponse;
import com.mono_car_rent.modules.rental.dto.RentalSaveDTO;
import com.mono_car_rent.modules.rental.dto.RentalUpdateDTO;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

public class RentalRepository extends AbstractRepository<Rental> {


    private RentalRepository() {
        super("rentals.json", new TypeToken<ArrayList<Rental>>() {});
    }

    /**
     * Save a rental.
     *
     * @param rentalSaveDTO the rental to save
     * @return the saved rental
     */
    public RepositoryResponse<Rental> save(RentalSaveDTO rentalSaveDTO) throws Throwable {
        Rental newRental = Rental.builder()
                .customerIdentityCard(rentalSaveDTO.customerIdentityCard())
                .vehiclePlate(rentalSaveDTO.vehiclePlate())
                .startDate(rentalSaveDTO.startDate())
                .rentalDays(rentalSaveDTO.rentalDays())
                .build();

        return super.save(newRental);
    }

    /**
     * Find a rental by id.
     *
     * @param id the rental id
     * @return the rental found or null
     */
    public RepositoryResponse<Rental> findById(int id) {
        for (Rental rental : this.getAll()) {
            if (rental.getId() == id) {
                return RepositoryResponse.<Rental>builder()
                        .success(true)
                        .value(rental)
                        .build();
            }
        }
        return RepositoryResponse.<Rental>builder()
                .success(false)
                .build();
    }

    /**
     * Update a rental.
     *
     * @param id the rental id
     * @param rentalUpdateDTO the rental to update
     * @return the updated rental
     */
    public RepositoryResponse<Rental> update(int id, RentalUpdateDTO rentalUpdateDTO) {
        RepositoryResponse<Rental> rentalResponse = findById(id);
        if (!rentalResponse.isSuccess()) {
            return null;
        }
        Rental found = rentalResponse.getValue();
        if (found == null) {
            return null;
        }

        found.setStartDate(rentalUpdateDTO.startDate());
        found.setRentalDays(rentalUpdateDTO.rentalDays());
        found.toBuilder().build();
        return super.update(rentalResponse.getIndex(), found);
    }

    public boolean existsByCustomerIdentityCard(String identityCard) {
        for (Rental rental : this.getAll()) {
            if (rental.getCustomerIdentityCard().equals(identityCard)) {
                return true;
            }
        }
        return false;
    }

    //#region Singleton
    private static final AtomicReference<RentalRepository> instance = new AtomicReference<>();
    public static RentalRepository getInstance() {
        if (instance.get() == null) {
            instance.set(new RentalRepository());
        }
        return instance.get();
    }
    //#endregion
}
