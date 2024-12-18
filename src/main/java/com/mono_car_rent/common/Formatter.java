package com.mono_car_rent.common;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Formatter {
    public static final String LANG = "es";
    public static final String COUNTRY = "CL";

    private Formatter() {
    }

    public static String price(double price) {
        return NumberFormat.getCurrencyInstance(new Locale(LANG, COUNTRY)).format(price);
    }

    public static String formatDate(Date date) {
        return new SimpleDateFormat("dd/MM/yyyy").format(date);
    }
}