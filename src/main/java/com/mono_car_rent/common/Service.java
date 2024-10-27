package com.mono_car_rent.common;

public class Service {
    public static final String LANG = "es";
    public static final String COUNTRY = "CL";

    private int id;

    public Service(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
