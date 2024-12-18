package com.mono_car_rent.modules.rental.rental;

import com.mono_car_rent.common.exception.general.BadRequestException;

import java.util.Calendar;
import java.util.Date;

public class Rental {
    private int id;
    private String vehiclePlate;
    private String customerIdentityCard;
    private Date startDate;
    private int rentalDays;
    private float pricePerDay;

    private Rental(int id, String vehiclePlate, String customerIdentityCard, Date startDate, int rentalDays, float pricePerDay) {
        this.id = id;
        this.vehiclePlate = vehiclePlate;
        this.customerIdentityCard = customerIdentityCard;
        this.startDate = startDate;
        this.rentalDays = rentalDays;
        this.pricePerDay = pricePerDay;
    }

    public static RentalBuilder builder() {
        return new RentalBuilder();
    }

    public Date getExpectedReturnDate() {
        var calendar = Calendar.getInstance();
        calendar.setTime(this.startDate);
        calendar.add(Calendar.DAY_OF_MONTH, this.rentalDays);

        return calendar.getTime();
    }

    public float getTotalPrice() {
        return this.pricePerDay * this.rentalDays;
    }

    public int getId() {
        return this.id;
    }

    public String getVehiclePlate() {
        return this.vehiclePlate;
    }

    public String getCustomerIdentityCard() {
        return this.customerIdentityCard;
    }

    public Date getStartDate() {
        return this.startDate;
    }

    public int getRentalDays() {
        return this.rentalDays;
    }

    public float getPricePerDay() {
        return this.pricePerDay;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setVehiclePlate(String vehiclePlate) {
        this.vehiclePlate = vehiclePlate;
    }

    public void setCustomerIdentityCard(String customerIdentityCard) {
        this.customerIdentityCard = customerIdentityCard;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setRentalDays(int rentalDays) {
        this.rentalDays = rentalDays;
    }

    public void setPricePerDay(float pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public RentalBuilder toBuilder() {
        return new RentalBuilder().id(this.id).vehiclePlate(this.vehiclePlate).customerIdentityCard(this.customerIdentityCard).startDate(this.startDate).rentalDays(this.rentalDays).pricePerDay(this.pricePerDay);
    }

    public static class RentalBuilder {

        private int id;
        private String vehiclePlate;
        private String customerIdentityCard;
        private Date startDate;
        private int rentalDays;
        private float pricePerDay;

        RentalBuilder() {
        }

        /**
         * Validates the rental days of a rental.
         */
        public boolean isValidRentalDays(int rentalDays) {
            return rentalDays > 1 && rentalDays < 10;
        }

        public Rental build() {
            if (id <= 0) {
                throw BadRequestException.invalidId();
            }
            if (vehiclePlate == null) {
                throw BadRequestException.isRequired("Vehicle plate");
            }
            if (customerIdentityCard == null) {
                throw BadRequestException.isRequired("Customer identity card");
            }
            if (pricePerDay <= 0) {
                throw BadRequestException.isRequired("Price per day");
            }
            if (startDate == null) {
                throw BadRequestException.isRequired("Start date");
            } else if (startDate.before(new Date())) {
                throw BadRequestException.invalidRentalDate();
            }
            if (!isValidRentalDays(rentalDays)) {
                throw BadRequestException.invalidRentalDays();
            }
            return new Rental(id, vehiclePlate, customerIdentityCard, startDate, rentalDays, pricePerDay);
        }

        public RentalBuilder id(int id) {
            this.id = id;
            return this;
        }

        public RentalBuilder vehiclePlate(String vehiclePlate) {
            this.vehiclePlate = vehiclePlate;
            return this;
        }

        public RentalBuilder customerIdentityCard(String customerIdentityCard) {
            this.customerIdentityCard = customerIdentityCard;
            return this;
        }

        public RentalBuilder startDate(Date startDate) {
            this.startDate = startDate;
            return this;
        }

        public RentalBuilder rentalDays(int rentalDays) {
            this.rentalDays = rentalDays;
            return this;
        }

        public RentalBuilder pricePerDay(float pricePerDay) {
            this.pricePerDay = pricePerDay;
            return this;
        }

        public String toString() {
            return "Rental.RentalBuilder(id=" + this.id + ", vehiclePlate=" + this.vehiclePlate + ", customerIdentityCard=" + this.customerIdentityCard + ", startDate=" + this.startDate + ", rentalDays=" + this.rentalDays + ", pricePerDay=" + this.pricePerDay + ")";
        }
    }
}
