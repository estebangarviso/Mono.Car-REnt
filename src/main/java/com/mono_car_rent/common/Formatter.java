package com.mono_car_rent.common;

import java.text.NumberFormat;
import java.util.Locale;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import java.text.SimpleDateFormat;
import java.util.Date;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Formatter {
    public static final String LANG = "es";
    public static final String COUNTRY = "CL";

    public static String price(double price) {
        return NumberFormat.getCurrencyInstance(new Locale(LANG, COUNTRY)).format(price);
    }

    public static String formatDate(Date date) {
        return new SimpleDateFormat("dd/MM/yyyy").format(date);
    }
}