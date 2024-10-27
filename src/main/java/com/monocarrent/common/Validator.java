package com.monocarrent.common;

public class Validator {
    public static boolean validateLicensePlate(String licensePlate) {
        return licensePlate.matches("^[A-Z]{3}[0-9]{3}$");
    }

    public static boolean validateIdentityCard(String identityCard) {
        return identityCard.matches("^[0-9]{8}-[0-9kK]{1}$");
    }
}
