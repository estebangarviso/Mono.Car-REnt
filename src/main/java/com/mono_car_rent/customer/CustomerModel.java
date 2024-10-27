package com.mono_car_rent.customer;

import com.mono_car_rent.common.Model;

public class CustomerModel extends Model {
    private String indentityCard;
    private String name;
    private Boolean validity = true;
    
    public CustomerModel(String indentityCard, String name) {
        super(CustomerRepository.nextId());
        this.indentityCard = indentityCard;
        this.name = name;
    }

    public CustomerModel(String indentityCard, String name, Boolean validity) {
        super(CustomerRepository.nextId());
        this.indentityCard = indentityCard;
        this.name = name;
        this.validity = validity;
    }

    public String getIndentityCard() {
        return indentityCard;
    }

    public void setIndentityCard(String indentityCard) {
        this.indentityCard = indentityCard;
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

    @Override
    public String toString() {
        return "CustomerModel{" +
                "indentityCard='" + indentityCard + '\'' +
                ", name='" + name + '\'' +
                ", validity=" + validity +
                '}';
    }
}
