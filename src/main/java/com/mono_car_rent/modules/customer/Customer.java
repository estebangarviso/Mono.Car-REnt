package com.mono_car_rent.modules.customer;

import com.mono_car_rent.common.Service;
import com.mono_car_rent.common.exception.general.BadRequestException;
import com.mono_car_rent.modules.customer.use_case.ValidateIdentityCardUseCase;

public class Customer extends Service implements ValidateIdentityCardUseCase {
    private String identityCard;
    private String name;
    private Boolean validity = true;
    
    public Customer() {
        super(CustomerRepository.nextId());
    }

    //#region Getters and Setters
    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        if (!isValidIdentityCard(identityCard)) {
            throw BadRequestException.invalidIdentityCard();
        }
        this.identityCard = identityCard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getValidity() {
        return validity;
    }

    public void setValidity(Boolean validity) {
        this.validity = validity;
    }
    //#endregion

    //#region Methods
    @Override
    public String toString() {
        return "Customer{" +
                "identityCard='" + identityCard + '\'' +
                ", name='" + name + '\'' +
                ", validity=" + validity +
                '}';
    }
    //#endregion

    //#region Validation

    @Override
    public boolean isValidIdentityCard(String identityCard) {
        return identityCard.matches("\\d{8}-[\\dk]");
    }
}
