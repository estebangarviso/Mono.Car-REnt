package com.mono_car_rent.rental;

import java.util.Locale;
import java.text.NumberFormat;

import java.util.Calendar;
import java.util.Date;

import com.mono_car_rent.common.Service;
import com.mono_car_rent.common.exception.general.BadRequestException;
import com.mono_car_rent.customer.Customer;
import com.mono_car_rent.vehicle.Vehicle;

public class Rental extends Service {
    private Vehicle vehicle;
    private Customer customer;
    private Date rentalDate;
    private int rentalHours;
    private double rentalPricePerHour;

    public Rental() {
        super(RentalRepository.nextId());
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        if (!customer.getValidity()) {
            throw BadRequestException.customerIsNotActive();
        }
        this.customer = customer;
    }

    public Date getRentalDate() {
        return rentalDate;
    }

    public String getRentalDateShortFormat() {
        // Must be in this format: DD-MM-YYYY
        var calendar = Calendar.getInstance();
        calendar.setTime(rentalDate);

        return String.format("%02d-%02d-%d", calendar.get(Calendar.DAY_OF_MONTH), calendar.get(Calendar.MONTH) + 1,
                calendar.get(Calendar.YEAR));
    }

    public void setRentalDate(Date rentalDate) {
        this.rentalDate = rentalDate;
    }

    public int getRentalHours() {
        return rentalHours;
    }

    public void setRentalHours(int rentalHours) {
        this.rentalHours = rentalHours;
    }

    public void setRentalDays(int rentalDays) {
        if (!validateRentalDays(rentalDays)) {
            throw BadRequestException.invalidRentalDays();
        }
        this.rentalHours = rentalDays * 24;
    }

    public double getRentalPricePerHour() {
        return rentalPricePerHour;
    }

    public double getRentalPricePerDay() {
        return rentalPricePerHour * 24;
    }

    public String getRentalPricePerDayFormatted() {
        return formatPrice(getRentalPricePerDay());
    }

    public void setRentalPricePerHour(double rentalPricePerHour) {
        this.rentalPricePerHour = rentalPricePerHour;
    }

    public void setRentalPricePerDay(double rentalPricePerDay) {
        this.rentalPricePerHour = rentalPricePerDay / 24;
    }

    public double getRentalTotalAmount() {
        return rentalHours * rentalPricePerHour;
    }

    public String getRentalTotalAmountFormatted() {
        return formatPrice(getRentalTotalAmount());
    }

    public int getRentalDays() {
        return rentalHours / 24;
    }

    //#region Methods

    public String formatPrice(double price) {
        return NumberFormat.getCurrencyInstance(new Locale(LANG, COUNTRY)).format(price);
    }
    @Override
    public String toString() {
        return "Rental{" +
                "ticketId=" + getId() +
                ", vehicle=" + vehicle.toString() +
                ", customer=" + customer.toString() +
                ", rentalDate=" + rentalDate +
                ", rentalDays=" + getRentalDays() +
                ", rentalTotalAmount=" + getRentalTotalAmount() +
                '}';
    }

    public String toReceipt() {
        return """

        ______________________________________________________________________________
        |                                                                            |
        |                          TICKET ARRIENDO DE VEHÍCULO
        |
        |           NÚMERO DE ARRIENDO  :  %d
        |           VEHÍCULO            :  %s %s %s
        |           PRECIO DIARIO       :  %s
        |                                                                                                            
        |   FECHA       CLIENTE             DÍAS        A PAGAR                            
        |   -------------------------------------------------------------------
        |   ----                                                                                                     
        |   %s  %s  %d          %s
        |   --------------------------------------------------------------------
        |   ----                                                                                                     
        |                                                                                                         
        |                                  _______________________________ 
        |                                           FIRMA CLIENTE               
        |
        |                                                                             |
        ______________________________________________________________________________

        """.stripIndent().formatted(getId(), vehicle.getLicensePlate(), vehicle.getBrand(), vehicle.getModel(),
                getRentalPricePerDayFormatted(), getRentalDateShortFormat(), customer.getName(), getRentalDays(), getRentalTotalAmountFormatted());
    }
    //#endregion

    //#region Validation
    /**
     * Validates the rental days.
     */
    public static boolean validateRentalDays(int rentalDays) {
        return rentalDays > 1 && rentalDays < 10;
    }
    //#endregion
}
