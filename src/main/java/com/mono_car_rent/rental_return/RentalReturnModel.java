package com.mono_car_rent.rental_return;

import java.util.Date;

import com.mono_car_rent.common.Model;
import com.mono_car_rent.rental.RentalModel;

public class RentalReturnModel extends Model {
    private RentalModel rental;
    private Date returnDate;

    public RentalReturnModel(RentalModel rental, Date returnDate) {
        super(rental.getId());
        this.rental = rental;
        this.returnDate = returnDate;
    }

    public RentalModel getRental() {
        return rental;
    }

    public void setRental(RentalModel rental) {
        this.rental = rental;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "RentalReturnModel{" +
                "rental=" + rental.toString() +
                ", returnDate=" + returnDate +
                '}';
    }
}
