package com.mono_car_rent.modules.customer;

import com.mono_car_rent.common.exception.general.BadRequestException;

public class Customer {
    private String identityCard;
    private String name;
    private Boolean validity = true;

    private Customer(String identityCard, String name, Boolean validity) {
        this.identityCard = identityCard;
        this.name = name;
        this.validity = validity;
    }

    public static CustomerBuilder builder() {
        return new CustomerBuilder();
    }

    public String getIdentityCard() {
        return this.identityCard;
    }

    public String getName() {
        return this.name;
    }

    public Boolean getValidity() {
        return this.validity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValidity(Boolean validity) {
        this.validity = validity;
    }

    public CustomerBuilder toBuilder() {
        return new CustomerBuilder().identityCard(this.identityCard).name(this.name).validity(this.validity);
    }

    /**
     * Builder for the Customer class.
     */
    public static class CustomerBuilder {
        private String identityCard;
        private String name;
        private Boolean validity;

        CustomerBuilder() {
        }

        /**
         * Validate the identity card format.
         *
         * @param identityCard the identity card to validate
         */
        private boolean isValidIdentityCard(String identityCard) {
            return identityCard.matches("\\d{8}-[\\dk]");
        }

        public Customer build() {
            if (identityCard == null) {
                throw BadRequestException.invalidIdentityCard();
            }
            if (name == null) {
                throw BadRequestException.isRequired("Name");
            }
            if (!isValidIdentityCard(identityCard)) {
                throw BadRequestException.invalidIdentityCard();
            }
            return new Customer(identityCard, name, validity);
        }

        public CustomerBuilder identityCard(String identityCard) {
            this.identityCard = identityCard;
            return this;
        }

        public CustomerBuilder name(String name) {
            this.name = name;
            return this;
        }

        public CustomerBuilder validity(Boolean validity) {
            this.validity = validity;
            return this;
        }

        public String toString() {
            return "Customer.CustomerBuilder(identityCard=" + this.identityCard + ", name=" + this.name + ", validity=" + this.validity + ")";
        }
    }
}
