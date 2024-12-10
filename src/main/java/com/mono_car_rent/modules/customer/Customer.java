package com.mono_car_rent.modules.customer;

import com.mono_car_rent.common.exception.general.BadRequestException;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
public class Customer {
    private String identityCard;
    private @Setter String name;
    private Boolean validity = true;

    /**
     * Validate the identity card format.
     *
     * @param identityCard the identity card to validate
     */
    private boolean isValidIdentityCard(String identityCard) {
        return identityCard.matches("\\d{8}-[\\dk]");
    }

    /**
     * Builder for the Customer class.
     */
    public class CustomerBuilder {
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
    }
}
