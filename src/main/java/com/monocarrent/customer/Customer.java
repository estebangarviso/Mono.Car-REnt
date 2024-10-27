package com.monocarrent.customer;

import com.monocarrent.common.Validator;
import com.monocarrent.common.exception.general.BadRequestException;

public class Customer {
    private String indentity_card;
    private String name;
    private Boolean validity = true;
    
    public Customer(String indentity_card, String name) {
        if (!Validator.validateIdentityCard(indentity_card)) {
            throw BadRequestException.invalidIdentityCard();
        }
        this.indentity_card = indentity_card;
        this.name = name;
    }

    public Customer(String indentity_card, String name, Boolean validity) {
        if (!Validator.validateIdentityCard(indentity_card)) {
            throw BadRequestException.invalidIdentityCard();
        }
        this.indentity_card = indentity_card;
        this.name = name;
        this.validity = validity;
    }

    public void disable(){
        validity = false;
    }
}
