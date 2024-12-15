package com.mono_car_rent.common.exception.general;

import com.mono_car_rent.common.exception.base.AppException;
import com.mono_car_rent.common.exception.base.AppExceptionCode;

public class NotFoundException extends AppException {
    public NotFoundException(AppExceptionCode code) {
        super(code);
    }

    public NotFoundException(AppExceptionCode code, Throwable cause) {
        super(code, cause);
    }

    //#region Common
    public static NotFoundException notFoundEntity(String entity, String identifier) {
        return new NotFoundException(AppExceptionCode.ENTITY_NOT_FOUND, new Throwable(entity + " with identifier " + identifier + " not found"));
    }
    //#endregion

    //#region Customer
    public static NotFoundException customerNotFound(String identityCard) {
        return new NotFoundException(AppExceptionCode.CUSTOMER_NOT_FOUND, new Throwable("Customer with identity card " + identityCard + " not found"));
    }
    //#endregion

    //#region Vehicle
    public static NotFoundException vehicleNotFound(String licensePlate) {
        return new NotFoundException(AppExceptionCode.VEHICLE_NOT_FOUND, new Throwable("Vehicle with license plate " + licensePlate + " not found"));
    }
    //#endregion

    //#region Rental
    public static NotFoundException rentalNotFound(String rentalId) {
        return new NotFoundException(AppExceptionCode.RENTAL_NOT_FOUND, new Throwable("Rental with ID " + rentalId + " not found"));
    }
    //#endregion
}
