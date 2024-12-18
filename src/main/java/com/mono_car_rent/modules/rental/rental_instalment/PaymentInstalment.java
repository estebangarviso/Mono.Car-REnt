package com.mono_car_rent.modules.rental.rental_instalment;

public class PaymentInstalment {
    private int number;
    private double value;
    private boolean paid = false;

    protected PaymentInstalment() {
    }

    public void pay() {
        paid = true;
    }

    public void unpay() {
        paid = false;
    }

    public int getNumber() {
        return this.number;
    }

    public double getValue() {
        return this.value;
    }

    public boolean isPaid() {
        return this.paid;
    }
}
