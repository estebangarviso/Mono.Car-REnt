package com.mono_car_rent.modules.rental_return;

import com.mono_car_rent.common.Service;
import com.mono_car_rent.common.exception.general.BadRequestException;
import com.mono_car_rent.modules.rental.Rental;
import com.mono_car_rent.modules.rental_return.use_case.ValidateReturnDateUseCase;
import java.util.Date;



public class RentalReturn extends Service implements ValidateReturnDateUseCase {
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
        if (!isValidReturnDate(returnDate)) {
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
                ", returnDate=" + returnDate.toString() +
                '}';
    }
    //#endregion

    //#region Validation
    @Override
    public boolean isValidReturnDate(Date returnDate) {
        return returnDate.after(rental.getRentalDate());
    }
}
