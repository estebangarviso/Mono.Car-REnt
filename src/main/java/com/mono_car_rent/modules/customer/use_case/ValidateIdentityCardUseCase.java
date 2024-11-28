package com.mono_car_rent.modules.customer.use_case;

public interface ValidateIdentityCardUseCase {
    /**
     * Validate the identity card format.
     */
    public boolean isValidIdentityCard(String identityCard);
}
