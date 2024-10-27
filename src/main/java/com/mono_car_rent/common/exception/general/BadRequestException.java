package com.mono_car_rent.common.exception.general;

import com.mono_car_rent.common.exception.base.AppException;
import com.mono_car_rent.common.exception.base.AppExceptionCode;

public class BadRequestException extends AppException {

    public BadRequestException(AppExceptionCode code) {
        super(code);
    }

    public BadRequestException(AppExceptionCode code, Throwable cause) {
        super(code, cause);
    }

    // Vehicle
    public static BadRequestException invalidLicensePlate() {
        return new BadRequestException(AppExceptionCode.INVALID_LICENSE_PLATE, new Throwable("Invalid license plate, must be 8 characters and uppercase"));
    }

    public static BadRequestException brandMustBeUpperCase() {
        return new BadRequestException(AppExceptionCode.INVALID_BRAND, new Throwable("Brand must be upper case"));
    }

    public static BadRequestException modelMustBeUpperCase() {
        return new BadRequestException(AppExceptionCode.INVALID_MODEL, new Throwable("Model must be upper case"));
    }

    public static BadRequestException invalidManufacturerYear() {
        return new BadRequestException(AppExceptionCode.INVALID_MANUFACTURER_YEAR, new Throwable("Invalid manufacturer year, must be between 2000 and current year"));
    }

    // Customer
    public static BadRequestException invalidIdentityCard() {
        return new BadRequestException(AppExceptionCode.INVALID_IDENTITY_CARD, new Throwable("Invalid identity card. Must be 10 digits total, penultimate must be a middle dash and last must be a number between 0 and 9 or a letter k"));
    }

    public static BadRequestException customerIsNotActive() {
        return new BadRequestException(AppExceptionCode.CUSTOMER_IS_NOT_ACTIVE, new Throwable("Customer is not active, cannot rent a vehicle"));
    }

    // Rental
    public static BadRequestException invalidRentalDays() {
        return new BadRequestException(AppExceptionCode.INVALID_RENTAL_DAYS, new Throwable("Invalid rental days, must be greater than 1 and less than 10"));
    }

    // Rental Return
    public static BadRequestException invalidReturnDate() {
        return new BadRequestException(AppExceptionCode.INVALID_RETURN_DATE, new Throwable("Invalid return date, cannot be before the rental date"));
    }
}