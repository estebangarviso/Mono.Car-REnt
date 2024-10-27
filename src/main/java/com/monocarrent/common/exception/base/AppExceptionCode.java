package com.monocarrent.common.exception.base;

public enum AppExceptionCode {

    // Bad Request
    INVALID_LICENSE_PLATE(1001, 400, "error.invalid.license.plate"),
    INVALID_BRAND(1002, 400, "error.invalid.brand"),
    INVALID_MODEL(1003, 400, "error.invalid.model"),
    INVALID_MANUFACTURER_YEAR(1004, 400, "error.invalid.manufacturer.year"),
    INVALID_IDENTITY_CARD(2001, 400, "error.invalid.identity.card"),
    CUSTOMER_IS_NOT_ACTIVE(2002, 400, "error.user.is.not.active"),
    INVALID_RENTAL_DAYS(4001, 400, "error.invalid.rental.days"),
    INVALID_RETURN_DATE(5002, 400, "error.invalid.return.date");

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