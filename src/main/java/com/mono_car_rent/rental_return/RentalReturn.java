package com.mono_car_rent.rental_return;

import java.util.Date;

import com.mono_car_rent.common.Service;
import com.mono_car_rent.common.exception.general.BadRequestException;
import com.mono_car_rent.rental.Rental;

public class RentalReturn extends Service {
    private Rental rental;
    private Date returnDate;

    public RentalReturn() {
        super(RentalReturnRepository.nextId());
    }

    //#region Getters and Setters
    public Rental getRental() {
        return rental;
    }

    public void setRental(Rental rental) {
        this.rental = rental;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        if (!validateReturnDate(returnDate)) {
            throw BadRequestException.invalidReturnDate();
        }
        this.returnDate = returnDate;
    }
    //#endregion

    //#region Methods
    @Override
    public String toString() {
        return "RentalReturn{" +
                "rental=" + rental.toString() +
                ", returnDate=" + returnDate +
                '}';
    }
    //#endregion

    //#region Validation
    /**
     * Validate the return date. Must be after the rental date.
     */
    public boolean validateReturnDate(Date returnDate) {
        return returnDate.after(rental.getRentalDate());
    }
}
