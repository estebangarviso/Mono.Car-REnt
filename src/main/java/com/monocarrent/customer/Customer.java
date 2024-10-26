package com.monocarrent.customer;
public class Customer {
    private String indentity_card;
    private String name;
    private Boolean validity=true;
    
    public Customer(String indentity_card, String name, Boolean validity) {
        this.indentity_card = indentity_card;
        this.name = name;
        this.validity = validity;
    }

    public void disable (){
        validity = false;
    }
}
