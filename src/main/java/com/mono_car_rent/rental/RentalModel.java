package com.mono_car_rent.rental;

import java.util.Date;

import com.mono_car_rent.common.Model;
import com.mono_car_rent.customer.CustomerModel;
import com.mono_car_rent.vehicle.VehicleModel;

public class RentalModel extends Model {

    private VehicleModel vehicle;
    private CustomerModel customer;
    private Date rentalDate;
    private int rentalHours;
    private double rentalPricePerHour;

    public RentalModel(VehicleModel vehicle, CustomerModel customer, Date rentalDate, int rentalHours, double rentalPricePerHour) {
        super(RentalRepository.nextId());
        this.vehicle = vehicle;
        this.customer = customer;
        this.rentalDate = rentalDate;
        this.rentalHours = rentalHours;
        this.rentalPricePerHour = rentalPricePerHour;
    }
    public VehicleModel getVehicle() {
        return vehicle;
    }

    public void setVehicle(VehicleModel vehicle) {
        this.vehicle = vehicle;
    }

    public CustomerModel getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerModel customer) {
        this.customer = customer;
    }

    public Date getRentalDate() {
        return rentalDate;
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
        this.rentalHours = rentalDays * 24;
    }

    public double getRentalPricePerHour() {
        return rentalPricePerHour;
    }

    public double getRentalPricePerDay() {
        return rentalPricePerHour * 24;
    }

    public void setRentalPricePerHour(double rentalPricePerHour) {
        this.rentalPricePerHour = rentalPricePerHour;
    }

    public double getRentalTotalAmount() {
        return rentalHours * rentalPricePerHour;
    }

    public int getRentalDays() {
        return rentalHours / 24;
    }

    @Override
    public String toString() {
        return "RentalModel{" +
                "vehicle=" + vehicle.toString() +
                ", customer=" + customer.toString() +
                ", rentalDate=" + rentalDate +
                ", rentalDays=" + getRentalDays() +
                ", rentalTotalAmount=" + getRentalTotalAmount() +
                '}';
    }
}
