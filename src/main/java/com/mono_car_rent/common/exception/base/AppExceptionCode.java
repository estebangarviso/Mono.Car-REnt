package com.mono_car_rent.common.exception.base;

public enum AppExceptionCode {

    //#region Common
    FIELD_IS_REQUIRED(1, 400, "error.field.is.required"),
    ENTITY_NOT_FOUND(2, 404, "error.entity.not.found"),
    INVALID_ID(3, 400, "error.invalid.id"),
    INVALID_PAGE(4, 400, "error.invalid.page"),
    //#endregion
    //#region Vehicle
    INVALID_LICENSE_PLATE(1001, 400, "error.invalid.license.plate"),
    INVALID_BRAND(1002, 400, "error.invalid.brand"),
    INVALID_MODEL(1003, 400, "error.invalid.model"),
    INVALID_MANUFACTURER_YEAR(1004, 400, "error.invalid.manufacturer.year"),
    VEHICLE_NOT_FOUND(1005, 404, "error.vehicle.not.found"),
    INVALID_RETURN_DATE(1006, 400, "error.invalid.return.date"), INVALID_PRICE_PER_DAY(5003, 400, "error.invalid.price.per.day"),
    //#endregion
    //#region Customer
    INVALID_IDENTITY_CARD(2001, 400, "error.invalid.identity.card"),
    CUSTOMER_IS_NOT_ACTIVE(2002, 400, "error.user.is.not.active"),
    CUSTOMER_NOT_FOUND(2003, 404, "error.customer.not.found"),
    CUSTOMER_HAS_RENTALS(2004, 400, "error.customer.has.rentals"),
    //#endregion
    //#region Rental
    INVALID_RENTAL_DAYS(4001, 400, "error.invalid.rental.days"),
    RENTAL_NOT_FOUND(4002, 404, "error.rental.not.found"),
    INVALID_RENTAL_DATE(4003, 400, "error.invalid.rental.date");
    //#endregion
    //#region Rental Return
    //#endregion

    AppExceptionCode(Integer codeApp, Integer statusCode, String messageKey) {
        this.codeApp = codeApp;
        this.statusCode = statusCode;
        this.messageKey = messageKey;
    }

    private final Integer codeApp;

    private final Integer statusCode;

    private final String messageKey;

    public Integer getCodeApp() {
        return codeApp;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public String getMessageKey() {
        return messageKey;
    }
}